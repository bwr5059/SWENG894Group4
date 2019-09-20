import axios from 'axios'  
  
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
  createNew: (uid, email, fName, lName, type, age, ethnicity, gender, profileComplete) => instance.put('/users/addProfile', {id: uid, email: email,firstName: fName,
    lastName: lName, type: type, age: age, ethnicity: ethnicity, gender: gender, profileComplete: profileComplete}),  
  // (R)ead  
  getAll: () => instance.get('user', {  
    transformResponse: [function (data) {  
      return data? JSON.parse(data)._embedded.user : data;  
    }]  
  }),  
  // (U)pdate  
 // updateForId: (id, text, completed) => instance.put('todos/'+id, {title: text, completed: completed}),  
  // (D)elete  
  //removeForId: (id) => instance.delete('todos/'+id)  
}