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
          <b-form-group id="input-group-3" label="Election Key:" label-for="input-3">
            <b-form-input
              id="input-3"
              v-model='form.electionKey'
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
      <!-- <b-button v-show="!editable" class="ml-1">Register</b-button> -->
      <b-button v-show="!editable" v-on:click="showmodal=true" class="ml-1">Set Policy</b-button>
      <b-button v-show="!editable" v-on:click="showmodal6=true" class="ml-1">Duplicate Election</b-button>
    </b-form>
        <b-modal id="modal-1" title="Set Voting Policy" v-model="showmodal">
            <b-card>
              <b-form>
                <b-form-group id="input-group-1" label="Polling Type:" label-for="input-1">
                  <!-- <b-form-select
                    id="input-1"
                    v-model="form.policyPollingType"
                    :options="polling"
                  ></b-form-select> -->
                  <b-form-select v-model='form.policyPollingType' size='sm' class='mr-1'>
                    <option :value="null">Select an option</option>
                    <option value="Minutes">Minutes</option>
                    <option value="Hours">Hours</option>
                    <option value="Days">Days</option>
                  </b-form-select>
                </b-form-group> 
                <b-form-group id="input-group-2" label="Frequency:" label-for="input-2">
                  <b-form-input
                    id="input-2"
                    v-model="form.policyFrequency"
                    placeholder="Enter numeric frequency"
                    type="number"
                  ></b-form-input>
                </b-form-group>  
                <b-form-group>
                  <b-form-checkbox
                    id="checkbox-1"
                    v-model="form.policyAbstain"
                    name="checkbox-1"
                    value= 1
                    unchecked-value= 0
                  >
                    Enable Abstain From Voting
                  </b-form-checkbox>
                </b-form-group>
                <b-form-group>
                  <b-form-checkbox
                    id="checkbox-2"
                    v-model="form.policyWrite"
                    name="checkbox-2"
                    value = 1
                    unchecked-value= 0
                  >
                    Enable Write-In
                  </b-form-checkbox>
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

<!-- Show the Table of Candidates Under this election -->
<b-card v-show="this.$parent.$parent.authorized">
   <div>
    <h2>Candidates Registered for this Election</h2>
    <b-button v-show="!editable" v-on:click="showmodalAssociateCandidate=true" class="ml-1 pull-right">Add Candidate to Election</b-button>
     <b-modal name="associateCandidateModal" id="modal-2" title="Associate Candidate with Election" v-model="showmodalAssociateCandidate">
            <b-card>
              <b-form>
            <b-form-group id="input-group-1" label="Candidate Name:" label-for="input-1">
              <b-form-select
                id="input-1"
                v-model="candidate_id"                
                :options="eligibleCandidates"
                 class="mb-3"
                 value-field="userID"
                  text-field="last_name"
              >
              </b-form-select>
            </b-form-group> 
            </b-form>
            </b-card>
          <template v-slot:modal-footer>
              <div class="w-100">
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right"
                  @click="associateCandidate"
                >
                Submit
                </b-button>
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right mr-2"
                  @click="showmodalAssociateCandidate=false"
                >
                Cancel
                </b-button>
              </div>
            </template>
        </b-modal>
    <b-table striped hover :items="candidates" selectable select-mode="single" @row-selected="selected" ref="selectableTable" :fields='fields_election_candidates' :busy="isBusy">
      <template v-slot:table-busy>
        <div class="text-center text-dark my-2">
          <b-spinner class="align-middle"></b-spinner>
          <strong>Loading...</strong>
        </div>  
      </template>
    </b-table>
  </div>
  <b-modal id="modal-6" title="Withdraw" v-model="showmodal6">
            <b-card>
              Are you sure you want to duplicate the election?
            </b-card>
          <template v-slot:modal-footer>
              <div class="w-100">
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right"
                  @click="duplicateElection"
                >
                Yes
                </b-button>
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right mr-2"
                  @click="showmodal6=false"
                >
                No
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
<b-tabs>
<b-tab title="Details" active>
<b-row>
<br>

</b-row>
<b-row>
  <b-col>
    {{isElectionClosed}}
   
    <br>
     <br>
    {{getWinner}} {{this.winner}}
    <br>
    <br>
  {{this.form.electionDescription}}
  </b-col>
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
</b-tab>
<b-tab id="analytics" title="Progress" v-if="this.data.data.closed==0">
  <fusioncharts
  :type="this.type"
  :width="this.width"
  :height="this.height"
  :dataFormat="this.dataFormat"
  :dataSource="this.dataSource"
></fusioncharts>
</b-tab>
<b-tab id="analytics" title="Results" v-if="this.data.data.closed==1">
  <fusioncharts
  :type="this.type"
  :width="this.width"
  :height="this.height"
  :dataFormat="this.dataFormat"
  :dataSource="this.dataSource"
></fusioncharts>
</b-tab>
</b-tabs>
<b-row>
  <!-- <br>
  Candidates: -->
  
  <b-container>
    <br>
  <b-card title="Candidates">
    <b-table striped hover :items="candidates" selectable select-mode="single"  ref="selectableTable" :fields="fields" @row-selected="enableVote" :busy="isBusy">
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
       <router-link :to='{path: `/app/home/Candidate/${data.item.last_name}/details`}' class="navbar-text mr-1" id='profile-button'> {{data.item.first_name}} {{data.item.last_name}} </router-link>
      </template>
    </b-table>
  </b-card>
  </b-container>
</b-row>
<br>
<b-row>
<b-button v-show="!editable&&!registered" class="ml-1" v-on:click="showRegisterDialog=true">Register</b-button>
<b-button v-show="!editable&&registered&&!hasVoted" class="ml-1" v-on:click="showmodal2=true">Withdraw</b-button>
<b-button v-show="registered&&isSelected&&!hasVoted" class="ml-1" v-on:click="validateVote">Vote</b-button>
<b-button v-show="registered&&!hasVoted" class="ml-1" v-on:click="showmodal5=true">Abstain from Voting</b-button>
<b-button v-show="this.userObj.type=='Voter'&&registered&!hasVoted" v-on:click="showWriteInCandidate=true" class="ml-1 pull-right">Write In Candidate</b-button>
<b-button v-show="hasVoted&&isSelected&&today<=this.form.electionCloseDate" v-on:click="showChangeVote=true" class="ml-1 pull-right">Change Vote</b-button>
</b-row>
</b-container>
<b-modal id="modal-3" title="Abstain From Voting" v-model="showmodal5">
            <b-card>
              Are you sure you want to abstain from voting in this election?
            </b-card>
          <template v-slot:modal-footer>
              <div class="w-100">
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right"
                  @click="abstainFromVoting"
                >
                Yes
                </b-button>
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right mr-2"
                  @click="showmodal5=false"
                >
                No
                </b-button>
              </div>
            </template>
        </b-modal>
<b-modal id="modal-2" title="Withdraw" v-model="showmodal2">
            <b-card>
              Are you sure you want to withdraw?
            </b-card>
          <template v-slot:modal-footer>
              <div class="w-100">
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right"
                  @click="withdraw"
                >
                Yes
                </b-button>
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right mr-2"
                  @click="showmodal2=false"
                >
                No
                </b-button>
              </div>
            </template>
        </b-modal>
        <b-modal id="modal-3" title="CastVote" v-model="showmodal3">
            <b-card>
              Are you sure you want to cast your vote?
            </b-card>
          <template v-slot:modal-footer>
              <div class="w-100">
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right"
                  @click="castVote"
                >
                Yes
                </b-button>
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right mr-2"
                  @click="showmodal3=false"
                >
                No
                </b-button>
              </div>
            </template>
        </b-modal>

           <!-- Show the Table of Candidates Written in by votwe Under this election -->
<!-- <b-card v-show="this.userObj.type=='Voter'">
   <div> -->
     <b-modal name="associateCandidateModal2" id="modal-2" title="Write in Candidate" v-model="showWriteInCandidate">
            <b-card>
              <b-form>
            <!-- <b-form-group id="input-group-1" label="Candidate Name:" label-for="input-1">
              <b-form-select
                id="input-1"
               v-model="candidate_id"                
                :options="eligibleCandidates"
                 class="mb-3"
                 value-field="userID"
                  text-field="last_name"
              >
              </b-form-select>
            </b-form-group>  -->
 <b-form-group id="input-group-1" label="Candidate Info:" label-for="input-1">
           
       <b-form-input
              id="input-2"
              v-model='write_in.firstname'
             required
             placeholder="First name"
            ></b-form-input>
            <b-form-input
              id="input-2"
              v-model='write_in.lastname'
              required
              placeholder="Last name"
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
                  @click="writeCandidate"
                >
                Write In
                </b-button>
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right mr-2"
                  @click="showWriteInCandidate=false"
                >
                Cancel
                </b-button>
              </div>
            </template>
        </b-modal>
        <b-modal id="modal-4" title="Change Vote" v-model="showChangeVote">
            <b-card>
              Are you sure you want to change your vote?
            </b-card>
          <template v-slot:modal-footer>
              <div class="w-100">
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right"
                  @click="changeVote"
                >
                Yes
                </b-button>
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right mr-2"
                  @click="showChangeVote=false"
                >
                No
                </b-button>
              </div>
            </template>
        </b-modal>
<!--     
  </div>
</b-card> -->
<b-modal id="modal-4" title="CastVote" v-model="showmodal4">
            <b-card>
              Are you sure you want to write in candidate and cast your vote?
            </b-card>
          <template v-slot:modal-footer>
              <div class="w-100">
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right"
                  @click="writeCandidate"
                >
                Yes
                </b-button>
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right mr-2"
                  @click="showmodal4=false"
                >
                No
                </b-button>
              </div>
            </template>
        </b-modal>

<!-- <b-card> -->
    <b-modal name="ElectionRegistrationModal" id="modal-2" title="Register for Election" v-model="showRegisterDialog">
            <b-card>
              <b-form>
           
 <b-form-group id="input-group-1" label="Election Registration Verification" label-for="input-1">
           
       <b-form-input
              id="input-2"
              v-model='election_key'
             required
             placeholder="Input Key"
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
                  @click="VerifyElectionKey"
                >
               Verify Election Key
                </b-button>
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right mr-2"
                  @click="showRegisterDialog=false"
                >
                Cancel
                </b-button>
              </div>
            </template>
        </b-modal>
<!-- </b-card> -->

</b-card>
</div>

</template>

<script>
import api from '@/apis/electionApi'
import api_candidate from '@/apis/candidateApi'
import api_user from '@/apis/userApi'
import VueFusionCharts from 'vue-fusioncharts';
import FusionCharts from 'fusioncharts';
import Column2D from 'fusioncharts/fusioncharts.charts';
import FusionTheme from 'fusioncharts/themes/fusioncharts.theme.fusion';
import Vue from 'vue';

Vue.use(VueFusionCharts, FusionCharts, Column2D, FusionTheme);
var tabbed = document.getElementById("analytics");

export default {
  name: 'electionDetails',
  props: {
    msg: String
  },
 
  data: () => {  
      
      return {  
        type: "column2d",
        width: "100%",
        height: "100%",
        dataFormat: "json",
        dataSource: {
        chart: {
            caption: "Votes by Candidate",
            xaxisname: "Candidate",
            yaxisname: "Total Votes",
            theme: "fusion"
          },
        data: null
        },
        currentElectionData: '',
        registrationData: '',
        registered: false,
        hasVoted:true,
        data: '',
        error: '',
        userObj: null,
        show: false,
        editable: false,
        regType: '',
        write_in:{
          firstname:'',
          lastname:''
        },
        form: {
          electionId: '',
          electionTitle: '',
          electionDescription: '',
          electionCloseDate: '',
          electionStartDate: '',
          policyPollingType: null,
          policyFrequency: '',
          policyMaxVotes: '',
          policyAbstain: 0,
          policyWrite: 0,
          electionKey:''
        },
        fields: null,
        fields_election_candidates:null,
        candidate_id:'',
        eligibleCandidates:null,
        selectedCandidate:null,
        isBusy: false,
        selecteditem: [],
        isSelected: false,
        showmodal: false,
        showmodal2: false,
        showmodal3: false,
        showmodal4: false,
        showmodal5: false,
        showmodal6: false,
        showmodalAssociateCandidate: false,
        showWriteInCandidate:false,
        showRegisterDialog:false,
        election_key:'',
        candidates: null,
        currentVotes: null,
        policySet: false,
        showChangeVote: false,
        today: null,
        isClosed: false,
        electionClosed: false,
        winner:'',
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
  },

  isElectionClosed(){
    if(this.data.data.closed==1){
    this.electionClosed=true;
      return "The election is now closed."
    }else{
      return "The election is open."
    }

  },

  getWinner(){
    if(this.data.data.closed==1){
      api.getWinner(this.form.electionId).then((response)=>{
        this.$log.debug("vote cast: ", response)
        //alert(response.data)
        this.winner="The winner is "+response.data;
        return "The winner is "+response.data[0];
      }).catch((error)=>
      this.$log.debug(error)) 
    }else{
    
    return ""
  }
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
      this.form.electionKey = this.data.data.election_key
      this.dataSource.data = [
            {
              label: "Luke Skywalker",
              value: "25"
            },
            {
              label: "Ben Solo",
              value: "40"
            },
          ]
      this.getCandidates()
      this.getAllCandidates()
      this.getRegistration()
      this.getPolicy()
      this.getVotes()
      this.calculateCurrentDay()
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error="Failed to get election"  
    });
    },
    /**getRegistration() checks if a user has registered against an election.
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
      } else if(this.regType=="Admin"){
        this.show = true
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
      api.updateElection(this.form.electionTitle, this.form.electionDescription, this.form.electionStartDate, this.form.electionCloseDate, this.form.electionId,this.form.electionKey).then((response)=>{
        this.$log.debug("Updated election", response)
      }).catch((error)=>{
        this.$log.debug(error)
      }).then(this.$router.push({ path: '/app/user/home' }))
      
    },
    VerifyElectionKey:function(){
if(this.election_key==this.form.electionKey){
  alert('Election Key Authenticated')
  this.showRegisterDialog=false
  this.register();
}else{
  alert('Invalid Key Supplied')
}
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
        this.showmodal2=false
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
    /**
     * castVote() calls the user API to cast a vote against the current election.
     */
    castVote: function(){
      this.showmodal3=false
      this.show = false
      this.$log.debug("casting vote...")
      //this.$log.debug(this.form.electionId, this.userObj.id, this.selecteditem[0].canID, "", "", this.userObj.type)
      api_user.castVote(this.form.electionId, this.userObj.id, this.selecteditem[0].canID, this.selecteditem[0].first_name, this.selecteditem[0].last_name, "cast").then((response)=>{
        this.$log.debug("vote cast: ", response)
        alert("Your vote has been cast!")
        this.getElection(this.form.electionId)
        this.hasVoted=true;
      }).catch((error)=>
      this.$log.debug(error))
    },
    /**getCandidates() calls the api to get candidates for the current election and creates an array of the returned candidates
     */
    getCandidates: function(){
      this.$log.debug("calling api: get candidates")
      api.getCandidates(this.form.electionId).then((response)=>{
          this.$log.debug("Candidate returned:", response)
        this.fields = ["Name", "Selected"]
        this.fields_election_candidates=['first_name','last_name']  
        this.candidates = response.data
        }).catch((error)=>
        this.$log.debug(error))
    },
    /**getAllCandidates() calls the api to return all candidates from the system and creates
    an array of the candidates
     */
    getAllCandidates: function(){
      this.$log.debug("calling api to: get all candidates ")
      api_candidate.getCandidates().then((response)=>{
          this.$log.debug("All Candidate returned:", response.data._embedded.candidates)
        this.eligibleCandidates = response.data._embedded.candidates
      }).catch((error)=>
        this.$log.debug(error))
    },
    /**
     * enableVote() function adds the current selected item in the candidate table to a variable to be used
     * when casting a vote.  Creates an array object of the current selected candidate and clears the array when
     * nothing is selected
     * @items - current selected item of candidate table
     */
    enableVote(items){
      this.selecteditem = items
       if(this.selecteditem[0]){
      this.isSelected = true
      }else{
        this.isSelected = false
      }
    },
    /**
     * setPolicy() function triggers the election api to create or modify the policy details of the current election
     */
    setPolicy: function(){
      this.$log.debug("calling api: setPolicy()")
      //note: when adding abstain or write in, need to convert to number using Number(this.form.policyAbstain)
      if(!this.policySet){
        this.showmodal=false
        this.show = false
        api.createPolicy(this.form.electionId, this.form.policyPollingType, Number(this.form.policyFrequency), Number(this.form.policyMaxVotes)) .then((response)=>{
          this.$log.debug("Policy set", response)
          if(response.status==200){alert("Election Policy Set!!")}
          this.getElection(this.form.electionId)
        }).catch((error)=>
          this.$log.debug(error),
          //alert(error),
          this.getElection(this.form.electionId))
      }else{
        this.showmodal=false
        this.show = false
        api.modifyPolicy(this.form.electionId, this.form.policyPollingType, Number(this.form.policyFrequency), Number(this.form.policyMaxVotes)) .then((response)=>{
          this.$log.debug("Policy set", response)
          if(response.status==200){alert("Election Policy Set!!")}
          
          this.getElection(this.form.electionId)
        }).catch((error)=>
        this.$log.debug(error),
        //alert(error),
        this.getElection(this.form.electionId))
      }
    },
    /**
     * getPolicy() function gets the current policy details for the loaded election
     * sets the policy form attributes for type, frequency, maxVotes, abstain and write in
     * also sets if the policy was set, which is used by the set policy function
     */
    getPolicy: function(){
      this.$log.debug("calling api: getPolicy()")
      api.getPolicy(this.form.electionId) .then((response)=>{
          this.$log.debug("Policy returned", response)
          if(response.data.electionID!=0){
            this.form.policyPollingType = response.data.type
            this.form.policyFrequency = response.data.frequency
            this.form.policyMaxVotes = response.data.num_votes
            this.policySet = true
          }
      }).catch((error)=>
        this.$log.debug(error))
    },
    associateCandidate: function(){
      this.$log.debug("calling api: associateCandidate()")
      api.registerCandidate(this.candidate_id,this.form.electionId) .then((response)=>{
          this.$log.debug("associate sCandidate set", response)
          if(response.status==200){
              alert("Candidate Added to Election!!")
              this.getCandidates()
              }
          this.showmodalAssociateCandidate=false
        //this.$router.push({path: `/app/home/elections`})
        }).catch((error)=>
        this.$log.debug(error))
    },
    disassociateCandidate: function(candidateID){
      this.$log.debug("calling api: associateCandidate()")
      api.withdrawCandidate(candidateID,this.form.electionId) .then((response)=>{
          this.$log.debug("disassociate sCandidate set", response)
          if(response.status==200){
              alert("Candidate Removed from Election!!")
              this.getCandidates()
              }
          this.showmodalAssociateCandidate=false
             //this.$router.push({path: `/app/home/elections`})
        }).catch((error)=>
        this.$log.debug(error))
    },
//WHEN SELECTED IT ASK to remo  ve the candidate
      selected: function(items){
      this.selectedCandidate = items
     var can_id=this.selectedCandidate[0].canID;
     var r = confirm("remove candidate from election ?");
if (r == true) {
   this.disassociateCandidate(can_id)
}
    },
    writeCandidate: function(){
       var r = confirm("Are you sure you want to write in candidate and cast your vote?");
if (r == true) {
      this.$log.debug("calling api: writeCandidate()")
       api_user.castVote(this.form.electionId, this.userObj.id, "", this.write_in.firstname, this.write_in.lastname, "cast").then((response)=>{
        this.$log.debug("write in cast: ", response)
        alert("Vote casted and Candidate Written in")
      this.showWriteInCandidate=false
      this.getElection(this.form.electionId)
      this.hasVoted=true;
      }).catch((error)=>
          this.$log.debug(error))
}
    },
    /**
     * getVotes() gets the current num of votes by electionID and by current user
     * @return number of votes
     */
    getVotes: function(){
      api.getVotes(this.form.electionId, this.userObj.id) .then((response)=>{
        this.$log.debug("got votes: ", response)
        this.currentVotes = Number(response.data)
        if(this.currentVotes==0){
          //show the writeIn Button
          this.hasVoted=false;
        }
      }).catch((error)=>
          this.$log.debug(error))
    },
    validateVote: function(){
      if(this.currentVotes!=0){
        alert("You have already cast a vote")
      }else{
        this.showmodal3=true
      }
    },

    calculateCurrentDay: function(){
      this.today = new Date();
      var dd = String(this.today.getDate()).padStart(2, '0');
      var mm = String(this.today.getMonth() + 1).padStart(2, '0'); //January is 0!
      var yyyy = this.today.getFullYear();
      //this.today = mm + '-' + dd + '-' + yyyy;
      this.today = yyyy + '-' + mm + '-' + dd;
    },
    /**
     * changeVote() function calls the user api and endpoint to change a voters vote.  This method
     * disables the showChangeVote variable to false, which hides modal-4.  It also changes the show
     * variable to false, which turns on the loading spinner.  If the response message is a successful
     * response, it triggers the getElection function for the current electionID to reload the election
     * details and updates all the current variables.
     */
    changeVote: function(){
      this.showChangeVote= false,
      this.show=false
      api_user.changeVote(this.form.electionId, this.userObj.id, this.selecteditem[0].canID, this.selecteditem[0].first_name, this.selecteditem[0].last_name).then((response)=>{
        this.$log.debug("vote changed: ", response)
        alert("Your vote has been changed!")
        this.getElection(this.form.electionId)
      }).catch((error)=>
      this.$log.debug(error))
    },

    abstainFromVoting : function(){
      this.showmodal5=false
      this.$log.debug("abstaining from casting vote...")
      api_user.castVote(this.form.electionId, this.userObj.id, "", "", "", "abstain").then((response)=>{
        this.$log.debug("vote cast: ", response)
        this.hasVoted=true;
        alert("You have successfully abstained from voting!")
        this.getElection(this.form.electionId)
      }).catch((error)=>
      this.$log.debug(error))
    },
    /**
     * duplicateElection() takes the current election details and calls the createElection endpoint to create a new election
     * using the existing election data that is currently loaded.  If successful it redirects the user to the new election
     * that was created.
     */
    duplicateElection: function(){
      this.showmodal6= false,
      this.show=false
      api.duplicateElection(this.form.electionTitle, this.form.electionDescription, this.form.electionStartDate, this.form.electionCloseDate, 
      this.form.electionId,this.form.electionKey).then((response)=>{
        this.$log.debug("Election duplicated", response)
        alert("Election Duplicated!")
        this.$router.push({ path: '/app/home/election/'+response.data.electionID+'/details' })
      }).catch((error)=>{
        this.$log.debug(error)
      })
      
    },
    
},
}
</script>
