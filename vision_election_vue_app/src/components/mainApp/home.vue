<template>
  <b-container>
    
      <b-card title="Welcome to Vision Election...">
        <b-card-text>
    <b>Create and Customize Elections</b> <br>

Fast and easy creation of elections without the hassle. Vision Election System offers many policy customization options including determining how many candidates a voter can vote for and options for writing in a candidate or abstaining from voting.  
<br>
<br>
<b>Manage your Elections</b> <br>

Worry free management of your elections. Control who can vote in elections by issuing a generated key and remove voters who can no longer vote. Add and remove candidates before the start of an election. 
<br>
<br>
<b>Participate in an Election</b> <br>

Participate as a voter in an election with a few simple clicks. Our easy to use interface makes your online voting experience worry free. 
        </b-card-text>
      </b-card>
   
  
  
   
   

    
  
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