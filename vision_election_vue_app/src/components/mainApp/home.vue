<template>
  <b-container>
    <b-row class ='d-flex justify-content-center'>
    Home content goes here.  You successfully logged in!
  
    </b-row>
  
  
    <b-row class ='d-flex justify-content-center'>
    <!-- email: {{userEmail}} id: {{userID}} firstname: {{userFName}} lastname: {{userLName}} -->

  

    
    </b-row>
    <b-row class ='d-flex justify-content-center'>
      <b-form-textarea
          id="textarea"
           
          placeholder="Enter something..."
          rows="3"
          max-rows="6"
      ></b-form-textarea>
    </b-row>

    
  
  </b-container>
        
 
    
</template>


<script>
import api from '@/apis/userApi'

export default {
  name: 'home',
  props: {
    msg: String,
   // activeUser: Object,
    
    
  },data: () => {  
      return {  
        //activeUser: null ,
        todos: [], 
        error: null,
        userProfileComplete: null,
        authorized: true,
        userObj: null,
        activeUser: null
      }  
    },  

    // computed: {

      
    //     userEmail: function () {
    //     return this.activeUser ? this.activeUser.email : ''
    //   },

    //      userID: function () {
    //     return this.activeUser ? this.activeUser.sub : ''
    // },
    //     userFName: function () {
    //     return this.activeUser ? this.activeUser.given_name : ''
    // },
    //     userLName: function () {
    //     return this.activeUser ? this.activeUser.family_name : ''
    // },

    


   


//you can retrieve first name as given_name and last name as family_name
        
  //  },

  
 created: function () {  
    
   this.$log.debug("home created")
  
   
  },  

  mounted: function() {
    this.$log.debug("home mounted")
  
     //this.refreshActiveUser();
     //this.$log.debug(this.activeUser.sub)
    //  this.checkUser();
     // this.checkUser();

  //   api.getUser(5)  
  //   .then(response => {  
  //     this.$log.debug("Data loaded: ", response.data)  
  //     this.todos = response.data  
  //     this.userProfileComplete = 1
  // })  
  //   .catch(error => {  
  //     this.$log.debug(error)  
  //     this.error = "User Profile not complete"  
  //     this.userProfileComplete = 0
      
  // }) 
 
  
  },
  watch: {  
    // '$parent.activeUser': 'refreshActiveUser',  
    // userProfileComplete: 'checkUser'
    '$parent.profileComplete': 'checkUser'
    
  },  
  
  methods: {  
    // async refreshActiveUser () {  
    //   this.activeUser = await this.$auth.getUser()  
    //   this.$log.debug('activeUser home',this.activeUser)  
      
    // },  

    refreshActiveUser: function()
    {
      this.activeUser =  this.$parent.activeUser
      this.$log.debug(this.activeUser)

      api.getUser(this.activeUser.sub)  
    .then(response => {  
      this.$log.debug("Data loaded: ", response.data)  
      this.todos = response.data  
      this.userProfileComplete = 1
  })  
    .catch(error => {  
      this.$log.debug(error)  
      this.error = "User Profile not complete"  
      this.userProfileComplete = 0
      
  })
    
  
    },
  
    // async handleLogout () {  
    //   await this.$auth.logout()  
    //   await this.refreshActiveUser()  
    //   this.$router.go('/')  
    // },

    checkUser() {
      
      if(this.$parent.profileComplete==0||this.$parent.profileComplete==null){
        alert("test2")
        this.$router.push({path:'/profile'})
      }
      
        
      

    },

 


  
  },

  
}
</script>