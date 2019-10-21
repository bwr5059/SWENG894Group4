<template>
    <div class=container>
        <b-navbar type="light">
            <b-navbar-nav>
                <router-link to="/app/user/home" class="navbar-brand">Election</router-link>
                <router-link v-show="authorized" to="/app/user/createElection" class="btn btn-secondary my-2 my-sm-0 mr-1" tag="button" id='home-button'> New </router-link>
                <router-link v-show="authorized" to="/app/user/addAdmin" class="btn btn-secondary my-2 my-sm-0 mr-1" tag="button" id='home-button'> Election Admin </router-link>
                <router-link to="/app/home/elections" class="btn btn-secondary my-2 my-sm-0 mr-1">Search all</router-link>
                <router-link to="/app/home/candidates" class="btn btn-secondary my-2 my-sm-0 mr-1">Candidates</router-link>
                <router-link v-show="isCandidate" to="/candidate" class="btn btn-secondary my-2 my-sm-0 mr-1">Candidate Profile</router-link>
            </b-navbar-nav>
            <b-navbar-nav class="ml-auto">
                <b-nav-form>
                <b-form-select v-model='searchType' size='sm' class='mr-1'>
                  <option :value="null">Select a search option</option>
                  <option value="Election">Election</option>
                  <option value="Candidate">Candidate</option>
                </b-form-select>
                <b-form-input size="sm" class="mr-sm-2" placeholder="Search" v-model="form.id" @keydown.enter.prevent></b-form-input>
                <b-button size="sm"  v-on:click='startSearch'>Search</b-button>
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
    isCandidate:false,
    name:'Duruike',
    form: {
          id: '',
  
        },
    userObj: null,
    profileComplete: null,
    activeUser: null,
    searchType: null,
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
/* startSearch() method gets current searchType var and triggers the appropriate
router path.  
*/
    
    startSearch: function(){
      if(this.searchType=="Election"){
        this.searchElection();
      }else if(this.searchType=="Candidate"){
        this.searchCandidate();
      }

    },

    searchElection: function(){
        alert("Routing to election details")
        this.$router.push({path: `/app/home/election/${this.form.id}/details`})
        this.form.id="";
        this.searchType=null;
    },

    searchCandidate: function(){
        alert("Routing to Candidate Profile")
       this.$router.push({path: `/app/home/Candidate/${this.form.id}/details`})
        this.form.id="";
        this.searchType=null;
    },


     refreshActiveUser: function()
    {
      this.activeUser =  this.$parent.activeUser
      this.$log.debug("home layout: ", this.activeUser) 
      api.getUser(this.activeUser.sub)  
    .then(response => {  
      this.$log.debug("Data loaded: ", response.data)  
      this.userObj = response.data  
      this.name=this.userObj.last_name;
      this.profileComplete = 1
     if(this.userObj.type == "Admin"){
        this.authorized = true
        
     }

 if(this.userObj.type == "Candidate"){
        this.isCandidate = true
        
     }
     
  })  
    .catch(error => {  
      this.$log.debug(error)  
      this.error = "User Profile not complete"  
      this.$log.debug("User not found")
      this.authorized = false
      this.isCandidate = false
      this.profileComplete = 0
      
  }) 
    },
    }
      
  
}
</script>