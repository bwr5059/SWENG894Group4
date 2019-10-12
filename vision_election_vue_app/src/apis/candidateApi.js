import axios from 'axios'  
import Vue from 'vue'  
  
const SERVER_URL = 'http://localhost:9000';  
  
const instance = axios.create({  
  baseURL: SERVER_URL,  
  timeout: 5000  
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
  
  // (R)ead  
  getCandidate: (id) => instance.get('/candidate/'+id, {  
    transformResponse: [function (data) {  
      return data? JSON.parse(data) : data;  
    }]  
  }),  

  getCandidateByName: (name) => instance.get('/candidate/name/'+name, {  
    transformResponse: [function (data) {  
      return data? JSON.parse(data) : data;  
    }]  
  }),  

  
  getCandidates: () => instance.get('/candidate', {  
    transformResponse: [function (data) {  
      return data? JSON.parse(data) : data;  
    }]  
  }), 
  // (U)pdate  
  modifyCandidate: (canID, userID, fname, lname, email, electionID, about, education, employment, experience, contact) => 
  instance.put('/candidate/modifyCandidate/'+canID, {canID: canID, userID: userID, first_name: fname, last_name: lname, 
    email: email, electionID: electionID,about: about, education: education, employment: employment, experience: experience, contact: contact}), 
 
    // (U)pdate  by Last Name
  modifyCandidateByName: (fname, lname, about, education, employment, experience, contact) => 
  instance.put('/candidate/modifyCandidateByName/'+lname, {canID: '', userID: '', first_name: fname, last_name: lname, 
    email: '', electionID: '',about: about, education: education, employment: employment, experience: experience, contact: contact}), 
 
  // (C)reate  
  addCandidate: (canID, userID, fname, lname, email, electionID, about, education, employment, experience, contact) => 
  instance.post('/candidate/addCandidate/', {canID: canID, userID: userID, first_name: fname, last_name: lname, 
    email: email, electionID: electionID,about: about, education: education, employment: employment, experience: experience, contact: contact}), 
  
    
 // updateForId: (id, text, completed) => instance.put('todos/'+id, {title: text, completed: completed}),  
  // (D)elete  
  //removeForId: (id) => instance.delete('todos/'+id)  
}