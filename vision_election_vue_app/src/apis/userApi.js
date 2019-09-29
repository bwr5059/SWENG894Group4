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
  createNew: (email, fName, lName, age, race, ethnicity, gender, address, city, state, zip) => 
  instance.post('/users/addProfile/Voter', {email: email, type: 'Voter', firstName: fName, lastName: lName, age: age, race: race, ethnicity: ethnicity
    ,gender: gender, address: address, city: city, state: state, zip: zip, profileComplete: "True"}),  
  // (R)ead  
  getUser: (id) => instance.get('/users/'+id, {  
    transformResponse: [function (data) {  
      return data? JSON.parse(data) : data;  
    }]  
  }),  
  // (U)pdate  
 // updateForId: (id, text, completed) => instance.put('todos/'+id, {title: text, completed: completed}),  
  // (D)elete  
  //removeForId: (id) => instance.delete('todos/'+id)  
}