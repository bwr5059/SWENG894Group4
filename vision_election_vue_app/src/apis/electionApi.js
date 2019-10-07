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
  // (C)reate  
  createNew: () => 
  instance.post('/election/addElection', {transformResponse: [function (data) {  
    return data? JSON.parse(data) : data;  
  }]  
}),  
  // (R)ead  ("/election/{electionId}"
  getElection: (eID) => instance.get('/election/'+eID, {
    transformResponse: [function (data) {  
      return data? JSON.parse(data) : data;  
    }]  
  }),  
  // (U)pdate  
  updateElection: (electionTitle, electionDescription, startDate, closeDate, id)=> instance.put('/election/modifyElection/'+id, {electionID: id, title: electionTitle,  
    start_date: startDate, close_date: closeDate, description: electionDescription, transformResponse: [function (data) {  
      return data? JSON.parse(data) : data;  
    }]  
  }),
  //get all elections "/election"
  getElections: ()=> instance.get("/election", { 
    transformResponse: [function (data) {  
      return data? JSON.parse(data) : data;  
    }]  
  }),
  //registers a voter against an election
  registerVoter: (voterID, electionID)=> instance.post('/election/associateVoter/'+electionID+'/'+voterID, {transformResponse: 
  [function (data) {
    return data? JSON.parse(data) : data;
  }]}),
  //registers a candidate against an election
  registerCandidate: (candidateID, electionID)=> instance.post('/election/associateCandidate/'+electionID+'/'+candidateID, {transformResponse: 
    [function (data) {
      return data? JSON.parse(data) : data;
    }]}),
  withdrawCandidate: (candidateID, electionID)=> instance.delete('/election/withdrawCandidate/'+electionID+'/'+candidateID, {transformResponse: 
    [function (data) {
      return data? JSON.parse(data) : data;
    }]}),
  // (D)elete  
  removeElection: (id) => instance.delete("/elections/remove/"+id, {transformResponse: [function (data) {  
    return data? JSON.parse(data) : data; 
  }]
})
}