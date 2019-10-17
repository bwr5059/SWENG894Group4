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
      <b-button v-show="!editable" v-on:click="showmodal=true" class="ml-1">Set Policy</b-button>
    </b-form>
        <b-modal id="modal-1" title="Set Voting Policy" v-model="showmodal">
            <b-card>
              <b-form>
            <b-form-group id="input-group-1" label="Polling Type:" label-for="input-1">
              <b-form-select
                id="input-1"
                v-model="form.policyPollingType"
                :options="polling"
              ></b-form-select>
            </b-form-group> 
            <b-form-group id="input-group-2" label="Frequency:" label-for="input-2">
              <b-form-input
                id="input-2"
                v-model="form.policyFrequency"
                placeholder="Enter numeric frequency"
                type="number"
              ></b-form-input>
            </b-form-group> 
            <b-form-group id="input-group-3" label="Number of Votes:" label-for="input-3">
              <b-form-input
                id="input-3"
                v-model="form.policyMaxVotes"
                placeholder="Enter number of max votes"
                type="number"
              ></b-form-input>
            </b-form-group> 
            
            </b-form>
            </b-card>
          <template v-slot:modal-footer>
              <div class="w-100">
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right"
                  @click="setPolicy"
                >
                Submit
                </b-button>
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right mr-2"
                  @click="showmodal=false"
                >
                Cancel
                </b-button>
              </div>
            </template>
        </b-modal>
  
</b-card>
<b-card v-show="!this.$parent.$parent.authorized" :title="voterCandidateHeader" :sub-title="voterCandidateSub">
  <div>
      <div class="d-flex justify-content-center mb-3">
        <b-spinner v-if="!show" label="Loading..."></b-spinner>
      </div>
  </div>
<b-container v-if="show">
<b-row>
{{this.form.electionDescription}}
</b-row>
<br>
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

</b-row>
<b-row>
  <!-- <br>
  Candidates: -->
  
  <b-container>
    <br>
  <b-card title="Candidates">
    <b-table striped hover :items="items" selectable select-mode="single"  ref="selectableTable" :fields="fields" @row-selected="enableVote" :busy="isBusy">
      <template v-slot:cell(selected)="{ rowSelected }">
        <template v-if="rowSelected">
          <span aria-hidden="true">&check;</span>
          <span class="sr-only">Selected</span>
        </template>
        <template v-else>
          <span aria-hidden="true">&nbsp;</span>
          <span class="sr-only">Not selected</span>
        </template>
      </template>
      <template v-slot:table-busy>
        <div class="text-center text-dark my-2">
          <b-spinner class="align-middle"></b-spinner>
          <strong>Loading...</strong>
        </div>
      </template>
      <template v-slot:cell(name)="data">
       <router-link :to='{path: `/app/home/Candidate/${data.item.last_Name}/details`}' class="navbar-text mr-1" id='profile-button'> {{data.item.first_Name}} {{data.item.last_Name}} </router-link>
      </template>
    </b-table>
  </b-card>
  </b-container>
</b-row>
<br>
<b-row>
<b-button v-show="!editable&&!registered" class="ml-1" v-on:click="register">Register</b-button>
<b-button v-show="!editable&&registered" class="ml-1" v-on:click="withdraw">Withdraw</b-button>
<b-button v-show="registered&&isSelected" class="ml-1" v-on:click="castVote">Vote</b-button>
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
        polling: [{text: 'Select One', value: null }, 'Minutes', 'Hours', 'Days'],
        currentElectionData: '',
        registrationData: '',
        registered: false,
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
          electionStartDate: '',
          policyPollingType: '',
          policyFrequency: '',
          policyMaxVotes: ''
        },
        fields: null,
        items: [
          { first_Name: "Lawrence" , last_Name: "Mielke", id: "12345"}
        ],
        isBusy: false,
        selecteditem: [],
        isSelected: false,
        showmodal: false,
        
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
      this.getCandidates()
      this.getRegistration()
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to get election"  
	});  
    },
    /**getRegistration() checks if a user has registered against an election.
    *currently no endpoint.  This is a placeholder function
    *@{id}: id of election
    **/
    getRegistration: function(){
      this.$log.debug("checking election registration...")
      if(this.regType=="Voter"){
        api.validateVoterRegistration(this.form.electionId, this.userObj.id).then((response)=>{
          if(response.status==200&&response.data=="Found"){
            this.$log.debug("Voter is registered", response)
            this.registered=true
            this.show = true
          }
          else{
            this.$log.debug("Voter is not registered", response)
            this.registered=false
            this.show = true
          }
        }).catch((error)=>
        this.$log.debug(error))
      }else if(this.regType=="Candidate"){
        api.validateCandidateRegistration(this.form.electionId, this.userObj.id).then((response)=>{
          if(response.status==200&&response.data=="Found"){
            this.$log.debug("Candidate is registered", response)
            this.registered=true
            this.show = true
          }
          else{
            this.$log.debug("Candidate is not registered", response)
            this.registered=false
            this.show = true
          }
        }).catch((error)=>
        this.$log.debug(error))
      }

      
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
        this.show = false
        this.$log.debug("calling api: registerVoter")
        api.registerVoter(this.userObj.id, this.form.electionId).then((response)=>{
          this.$log.debug("Voter registered", response)
          alert("Registration Successful")
          this.getElection(this.form.electionId)
        }).catch((error)=>
        this.$log.debug(error))
      }else if(this.regType=="Candidate"){
        this.show = false
        this.$log.debug("calling api: registerCandidate")
        api.registerCandidate(this.userObj.id, this.form.electionId).then((response)=>{
          this.$log.debug("Candidate registered", response)
          alert("Registration Successful")
          this.getElection(this.form.electionId)
        }).catch((error)=>
        this.$log.debug(error))
      }
    },
    /**withdraw() calls the api to withdraw a candidate from an election
     * 
     */
    withdraw: function(){
      if(this.regType=="Candidate"){
        this.show = false
        this.$log.debug("calling api: withdrawCandidate")
        api.withdrawCandidate(this.userObj.id, this.form.electionId).then((response)=>{
          this.$log.debug("Candidate Withdrawn", response)
          alert("Withdrawn from election")
          this.getElection(this.form.electionId)
        }).catch((error)=>
        this.$log.debug(error))
      }else{
        this.show = false
        this.$log.debug("calling api: withdrawVoter")
        api.withdrawVoter(this.userObj.id, this.form.electionId).then((response)=>{
          this.$log.debug("Candidate Withdrawn", response)
          if(response.status==200){alert("Withdrawn from election")
          this.getElection(this.form.electionId)}
        }).catch((error)=>
        this.$log.debug(error))
      }
    },
    castVote: function(){
      this.$log.debug("casting vote...")
    },

    getCandidates: function(){
      this.$log.debug("calling api: get candidates")
      this.fields = ["Name", "Selected"]
    },

    enableVote(items){
      this.selecteditem = items
       if(this.selecteditem[0]){
      this.isSelected = true
      }else{
        this.isSelected = false
      }
    },

    setPolicy: function(){
      this.$log.debug("calling api: setPolicy()")
      api.createPolicy(this.form.electionId, this.form.policyPollingType, this.form.policyFrequency, this.form.policyMaxVotes) .then((response)=>{
          this.$log.debug("Policy set", response)
          if(response.status==200){alert("Election Policy Set!!")}
          this.showmodal=false
        }).catch((error)=>
        this.$log.debug(error))
    }
}
}
</script>
