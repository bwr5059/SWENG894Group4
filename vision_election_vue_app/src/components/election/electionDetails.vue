<template>
<div>
<b-card v-show="this.$parent.$parent.authorized">
      <div>
        <div class="d-flex justify-content-center mb-3">
          <b-spinner v-if="!show" label="Loading..."></b-spinner>
        </div>
      </div>
      <b-form v-if="show" fluid>
        <b-row>
          <b-col>
          <b-form-group id="input-group-2" label="Election ID:" label-for="input-2">
            <b-form-input
              id="input-2"
              v-model='form.electionId'
              required
              readonly
            ></b-form-input>
          </b-form-group>
          </b-col>
          <b-col>
          <b-form-group id="input-group-3" label="Election Title:" label-for="input-3">
            <b-form-input
              id="input-3"
              v-model='form.electionTitle'
              required
              :disabled="!editable"
              
            ></b-form-input>
          </b-form-group>
          </b-col>
          <b-col>
          <b-form-group id="input-group-4" label="Description:" label-for="input-4">
            <b-form-input
              id="input-4"
              required
              v-model='form.electionDescription'
              :disabled="!editable"
            ></b-form-input>
          </b-form-group>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
          <b-form-group id="input-group-5" label="Start Date:" label-for="input-5">
            <b-form-input
              id="input-4"
              type="date"
              required
              v-model='form.electionStartDate'
              :disabled="!editable"
            ></b-form-input>
          </b-form-group>
          </b-col>
          <b-col>
          <b-form-group id="input-group-6" label="Close Date:" label-for="input-6">
            <b-form-input
              id="input-4"
              type="date"
              required
              v-model='form.electionCloseDate'
              :disabled="!editable"
            ></b-form-input>
          </b-form-group>
          </b-col>
        </b-row>
      <b-button v-show="!editable&this.$parent.$parent.authorized" v-on:click="edit">Edit</b-button>
      <b-button v-show="editable" class="mr-1" v-on:click="cancel">Cancel</b-button>
      <b-button v-show="editable" v-on:click="updateElection()">Submit</b-button>
      <b-button v-show="!editable" class="ml-1">Register</b-button>
    </b-form>
</b-card>
  <div>
      <div class="d-flex justify-content-center mb-3">
        <b-spinner v-if="!show" label="Loading..."></b-spinner>
      </div>
  </div>
<b-card v-show="!this.$parent.$parent.authorized&&show" :title="voterCandidateHeader" :sub-title="voterCandidateSub">
<b-container>
<b-row>
{{this.form.electionDescription}}
</b-row>
<b-row>
  <b-col>
    <b-card-text>
    Start: {{this.form.electionStartDate}}
    </b-card-text>
  </b-col>
  <b-col>
    <b-card-text>
    End: {{this.form.electionCloseDate}}
    </b-card-text>
  </b-col>
  <b-col>
  </b-col>
  <b-col>
  </b-col>
  <b-col>
  </b-col>
</b-row>
<b-row>
  Candidates:
</b-row>
<b-row>

<b-button v-show="!editable" class="ml-1" v-on:click="register">Register</b-button>
<b-button v-show="!editable&&this.regType=='Candidate'" class="ml-1" v-on:click="withdraw">Withdraw</b-button>
</b-row>
</b-container>
</b-card>
</div>

</template>

<script>

import api from '@/apis/electionApi'
export default {
  name: 'electionDetails',
  props: {
    msg: String
  },
  data: () => {  
      return {  
        //activeUser: null,
        currentElectionData: '',
        registrationData: '',
        data: '',
        error: '',
        userObj: null,
        show: false,
        editable: false,
        regType: '',
        form: {
          electionId: '',
          electionTitle: '',
          electionDescription: '',
          electionCloseDate: '',
          electionStartDate: ''
        },
      }  
    },  

computed: {
  /**voterCandidateHeader() is computed data to return the current electionID that
   * is displayed in the data card title
   * @return - returns "Election ID: "" and the current election ID
   */
  voterCandidateHeader(){
    return "Election ID: "+this.form.electionId;
  },
  /**voterCandidateSub() is computed data to return the current electionID that
   * is displayed in the data card sub title
   * @return - returns the current election Title
   */
  voterCandidateSub(){
    return this.form.electionTitle;
  }
},

created: function(){
  this.$log.debug("Setting election Data:")
    //sets the current election ID that is pulled from the route/URL
    this.currentElectionData = this.$route.params.eID
    this.$log.debug("Getting election:")
    //calls the getElection() function
    this.getElection(this.$route.params.eID);
     this.$log.debug("Created:")
},

mounted: function(){
  // this.currentElectionData = this.$route.params.eID
  //   this.getElection(this.$route.params.eID);
  this.$log.debug("Mounted:")
  //sets the userObj object from the parent userObj
  this.userObj = this.$parent.$parent.userObj
  //sets the registration type from the userObj
  this.regType = this.userObj.type
},

watch: {
  //checks when the routing change and refreshes the current election
    '$route': 'refreshData' 
},

methods: {
    //refreshData() function gets the current election data and sets it to the election ID from the routing
    //and then calls the getElection() function
    async refreshData () {  
       this.$log.debug("Refreshing data:")
      this.currentElectionData = this.$route.params.eID
      this.getElection(this.currentElectionData)
    },  
    /**getElection() function calls the getElection API and returns the json data.  If the response
     * is successful, it sets the current form data to the election data received and sets the show variable
     * to show the data card.
     * @{id} inbound id of the election being retrieved by the api
     * update response data
     */
    getElection: function(id){
      this.$log.debug("Calling API:")
      this.show=false
      api.getElection(id).then( (response) => {  
      this.$log.debug("Success getting election:", response);  
      this.data = response
      this.form.electionId = this.data.data.electionID
      this.form.electionTitle = this.data.data.title
      this.form.electionDescription = this.data.data.description
      this.form.electionCloseDate = this.data.data.close_date
      this.form.electionStartDate = this.data.data.start_date
      this.show = true
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to get election"  
	});  
    },
    /**getRegistration() checks if a user has registered against an election.
    *currently no endpoint.  This is a placeholder function
    *@{id}: id of election
    **/
    getRegistration: function(id){
    },
    /**edit() enables editing of election
    **/
    edit: function(){
    this.editable=true
    },
    /**cancel() disables editing of election
    **/
    cancel: function(){
    this.editable=false
    },
    /**updateElection() function calls the api to update the election data.  
     * gets the current form data for the electionDescription, ElectionStartDate
     * and electionCloseDate.  If successful redirects to the home page.
     */
    updateElection: function(){
      api.updateElection(this.form.electionTitle, this.form.electionDescription, this.form.electionStartDate, this.form.electionCloseDate, this.form.electionId).then((response)=>{
        this.$log.debug("Updated election", response)
      }).catch((error)=>{
        this.$log.debug(error)
      }).then(this.$router.push({ path: '/app/user/home' }))
      
    },
    /**register() gets the current registration type and submits to the relevant API to register the current
    *user to an election
    **/
    register: function(){
      if(this.regType=="Voter"){
        this.$log.debug("calling api: registerVoter")
        api.registerVoter(this.userObj.id, this.form.electionId).then((response)=>{
          this.$log.debug("Voter registered", response)
          alert("Registration Successful")
        }).catch((error)=>
        this.$log.debug(error))
      }else if(this.regType=="Candidate"){
        this.$log.debug("calling api: registerCandidate")
        api.registerCandidate(this.userObj.id, this.form.electionId).then((response)=>{
          this.$log.debug("Candidate registered", response)
          alert("Registration Successful")
        }).catch((error)=>
        this.$log.debug(error))
      }
    },
    /**withdraw() calls the api to withdraw a candidate from an election
     * 
     */
    withdraw: function(){
      if(this.regType=="Candidate"){
        this.$log.debug("calling api: withdrawCandidate")
        api.withdrawCandidate(this.userObj.id, this.form.electionId).then((response)=>{
          this.$log.debug("Candidate Withdrawn", response)
          alert("Withdrawn from election")
        }).catch((error)=>
        this.$log.debug(error))
      }
    }
}
}
</script>
