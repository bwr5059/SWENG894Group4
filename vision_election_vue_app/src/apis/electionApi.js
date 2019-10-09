import axios from 'axios'  
import Vue from 'vue'  
  
const SERVER_URL = 'http://localhost:9000';  
  
const instance = axios.create({  
  baseURL: SERVER_URL,  
  timeout: 1000  
});  
  
export default {  
    async execute(method, resource, data, config) {  
        let accessToken = await Vue.prototype.$auth.getAccessToken()  
        return instance({  
          method:method,  
          url: resource,  
          data,  
          headers: {  
                Authorization: `Bearer ${accessToken}`  
          },  
          ...config  
        })  
      }, 
  // (C)reate  
  createNew: () => 
  instance.post('/elections/addElection', {transformResponse: [function (data) {  
    return data? JSON.parse(data) : data;  
  }]  
}),  
  // (R)ead  ("/elections/{electionId}"
  getElection: (eID) => instance.get('/elections/'+eID, {
    transformResponse: [function (data) {  
      return data? JSON.parse(data) : data;  
    }]  
  }),  
  // (U)pdate  
  updateElection: (electionTitle, electionDescription, id)=> instance.put('/elections/modify/'+id, {title: electionTitle,  
    transformResponse: [function (data) {  
      return data? JSON.parse(data) : data;  
    }]  
  }),

  getElections: ()=> instance.get("/elections", { 
    transformResponse: [function (data) {  
      return data? JSON.parse(data) : data;  
    }]  
  }),


 // updateForId: (id, text, completed) => instance.put('todos/'+id, {title: text, completed: completed}),  
  // (D)elete  
  removeElection: (id) => instance.delete("/elections/remove/"+id, {transformResponse: [function (data) {  
    return data? JSON.parse(data) : data; 
  }]
})
}