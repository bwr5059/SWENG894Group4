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

  duplicateElection: (electionTitle, electionDescription, startDate, closeDate, id, electionKey)=> instance.post('/election/addElection/', {title: electionTitle,  
    start_date: startDate, close_date: closeDate, description: electionDescription, election_key:electionKey, transformResponse: [function (data) {  
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
  updateElection: (electionTitle, electionDescription, startDate, closeDate, id,electionKey)=> instance.put('/election/modifyElection/'+id, {electionID: id, title: electionTitle,  
    start_date: startDate, close_date: closeDate, description: electionDescription, election_key:electionKey, transformResponse: [function (data) {  
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
  removeElection: (id) => instance.delete("/election/removeElection/"+id, {transformResponse: [function (data) {  
    return data? JSON.parse(data) : data; 
  }]
}),

  withdrawVoter: (voterID, electionID)=> instance.delete('/election/withdrawVoter/'+electionID+'/'+voterID, {transformResponse: 
    [function (data) {
      return data? JSON.parse(data) : data;
    }]}),

    createPolicy: (electionID, pType, pFrequency, pNumVoters)=> instance.post('/election/createPolicy', {electionID: electionID, type: pType, frequency: pFrequency, num_votes: pNumVoters
    , transformResponse: 
      [function (data) {
        return data? JSON.parse(data) : data;
      }]}),

      modifyPolicy: (electionID, pType, pFrequency, pNumVoters)=> instance.put('/election/modifyPolicy', {electionID: electionID, type: pType, frequency: pFrequency, num_votes: pNumVoters
        , transformResponse: 
          [function (data) {
            return data? JSON.parse(data) : data;
          }]}),

  validateVoterRegistration: (electionID, voterID)=> instance.get('/election/validateVoter/'+electionID+'/'+voterID, {transformResponse: 
    [function (data) {
      return data
    }]}),

    validateCandidateRegistration: (electionID, voterID)=> instance.get('/election/validateCandidate/'+electionID+'/'+voterID, {transformResponse: 
      [function (data) {
        return data
      }]}),

      getCandidates: (electionID)=> instance.get('/election/viewCandidates/'+electionID, {transformResponse: 
        [function (data) {
          return data? JSON.parse(data) : data;
        }]},),

    getPolicy: (electionID)=> instance.get('/election/getPolicy/'+electionID, {transformResponse: 
        [function (data) {
          return data? JSON.parse(data) : data;
        }]}),

    getVotes: (electionID, voterID)=> instance.get('/election/getVotesByVoter/'+electionID+'/'+voterID, {transformResponse: 
      [function (data) {
        return data
      }]}),


}