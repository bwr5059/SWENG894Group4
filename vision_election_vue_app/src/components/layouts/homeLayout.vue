<template>
    <div class=container>
        <b-navbar type="light">
            <b-navbar-nav>
                <router-link to="/app/user/home" class="navbar-brand">Election</router-link>
                <router-link v-show="authorized" to="/app/user/createElection" class="btn btn-secondary my-2 my-sm-0 mr-1" tag="button" id='home-button'> New </router-link>
                <router-link v-show="authorized" to="/app/user/addAdmin" class="btn btn-secondary my-2 my-sm-0 mr-1" tag="button" id='home-button'> Election Admin </router-link>
                <router-link to="/app/home/elections" class="btn btn-secondary my-2 my-sm-0 mr-1">Search all</router-link>
            </b-navbar-nav>
            <b-navbar-nav class="ml-auto">
                <b-nav-form>
                <b-form-input size="sm" class="mr-sm-2" placeholder="Search" v-model="form.id" @keydown.enter.prevent></b-form-input>
                <b-button size="sm"  v-on:click='searchElection'>Search</b-button>
                </b-nav-form>
            </b-navbar-nav>
        </b-navbar>
        <router-view></router-view>
    </div>
</template>

<script>

import api from '@/apis/userApi'
export default {
  name: 'homeLayout',
  props: {
    msg: String,
    
   
  },

   data: () => {  
      return {
    authorized: false,
    form: {
          id: '',
        },
    userObj: null,
    profileComplete: null,
    activeUser: null
      }
},
created: function(){
  this.$log.debug("home layout created")
 // this.refreshActiveUser()
  
},

 watch: {  
    '$parent.activeUser': 'refreshActiveUser',  

    
  },  
mounted: function() {
  this.$log.debug("home layout mounted")

  //   api.getUser(this.activeUser.sub)  
  //   .then(response => {  
  //     this.$log.debug("Data loaded: ", response.data)  
  //     this.userObj = response.data  
  //     this.profileComplete = 1
  //    if(this.userObj.type == "Admin"){
  //       this.authorized = true
        
  //    }
  // })  
  //   .catch(error => {  
  //     this.$log.debug(error)  
  //     this.error = "User Profile not complete"  
  //     this.$log.debug("User not found")
  //     this.authorized = false
  //     this.profileComplete = 0
      
  // }) 
  
  },

    methods: {
    searchElection: function(){
        alert("test")
        this.$router.push({path: `/app/home/election/${this.form.id}/details`})
    },
     refreshActiveUser: function()
    {
      this.activeUser =  this.$parent.activeUser
      this.$log.debug("home layout: ", this.activeUser) 
      api.getUser(this.activeUser.sub)  
    .then(response => {  
      this.$log.debug("Data loaded: ", response.data)  
      this.userObj = response.data  
      this.profileComplete = 1
     if(this.userObj.type == "Admin"){
        this.authorized = true
        
     }
  })  
    .catch(error => {  
      this.$log.debug(error)  
      this.error = "User Profile not complete"  
      this.$log.debug("User not found")
      this.authorized = false
      this.profileComplete = 0
      
  }) 
    },
    }
      
  
}
</script>