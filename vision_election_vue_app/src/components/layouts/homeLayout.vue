<template>
    <div class=container>
        <b-navbar type="light">
            <b-navbar-nav>
                <router-link v-show="!authorized" to="/app/user/home" class="navbar-brand">Participant</router-link>
                <router-link v-show="authorized" to="/app/user/home" class="navbar-brand">Election Manager</router-link>
                <router-link v-show="authorized" to="/app/user/createElection" class="btn-sm btn-secondary my-2 my-sm-1 mr-1" > New </router-link>
                <router-link v-show="authorized" to="/app/user/addAdmin" class="btn-sm btn-secondary my-2 my-sm-1 mr-1" > Election Admin </router-link>
                <router-link to="/app/home/elections" class="btn-sm btn-secondary my-2 my-sm-1 mr-1">Search all</router-link>
                <router-link to="/app/home/candidates" class="btn-sm btn-secondary my-2 my-sm-1 mr-1">Candidates</router-link>
                <router-link v-show="isCandidate" to="/candidate" class="btn-sm btn-secondary my-2 my-sm-1 mr-1">Candidate Profile</router-link>
            </b-navbar-nav>
            <b-navbar-nav class="ml-auto">
                <b-nav-form>
                <b-form-select v-model='searchType' size='sm' class='mr-1'>
                  <option :value="null">Select...</option>
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
import Eapi from '@/apis/electionApi'
import Capi from '@/apis/candidateApi'
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
        elections: null,
        candidates: null
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
      Eapi.getElections().then( (response) => {  
        this.$log.debug("Success getting elections:", response);
        this.elections=response.data
        if(this.validateElection(this.form.id)){  
        this.$router.push({path: `/app/home/election/${this.form.id}/details`})
        this.form.id="";
        this.searchType=null;
        this.elections=null;
        }else{
          alert("Election not found")
          this.form.id="";
          this.searchType=null;
          //this.elections=null;
        }
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to get elections"  
	});  
    },
      validateElection: function(electionID){
        this.$log.debug("Checking elections", this.elections)
        for(var a = 0; a<this.elections.length; a++){
          if(this.elections[a].electionID==electionID){
            return true
          }
        }
    },

    validateCandidate: function(candidate){
      this.$log.debug("Checking candidate", this.candidates)
        for(var a = 0; a<this.candidates.length; a++){
          if(this.candidates[a].last_name==candidate){
            return true
          }
        }
    },

    searchCandidate: function(){
      //   alert("Routing to Candidate Profile")
      //  this.$router.push({path: `/app/home/Candidate/${this.form.id}/details`})
      //   this.form.id="";
      //   this.searchType=null;
       Capi.getCandidates().then( (response) => {  
        this.$log.debug("Success getting candidates:", response);
        this.candidates=response.data._embedded.candidates
        if(this.validateCandidate(this.form.id)){  
        this.$router.push({path: `/app/home/Candidate/${this.form.id}/details`})
        this.form.id="";
        this.searchType=null;
        //this.candidates=null;
        }else{
          alert("Candidate not found")
          this.form.id="";
          this.searchType=null;
          //this.elections=null;
        }
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to get elections"  
	});  
    },
     refreshActiveUser: function(){
      this.activeUser =  this.$parent.activeUser
      this.$log.debug("home layout: ", this.activeUser) 
      api.getUser(this.activeUser.sub) .then((response) =>{ 
      this.$log.debug("Data loaded refresh: ", response)
      if(response.status==200&&response.data.id!=null){
        this.$log.debug("Data loaded refresh success: ", response.data)
        this.userObj = response.data  
        this.profileComplete = 1
      }else{
         this.$log.debug("redirecting to profile") 
        this.$router.push({path:'/profile'})
      }
      if(response.data.type == "Admin"){
          this.authorized = true
      }
        if(response.data.type == "Candidate"){
          this.isCandidate = true
      }
      })  
    .catch(error => {  
      this.$log.debug(error)  
      //this.error = "User Profile not complete"  
      this.$log.debug("User not found home layout")
      this.authorized = false
      this.profileComplete = 0
      
  }) 
    },
    
      
    }
}
</script>