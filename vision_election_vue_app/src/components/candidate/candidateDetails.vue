<template>
<div>
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
 text goes here
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
        data: '',
        error: '',
        userObj: null,
        show: false,
        form: {
          canFname: '',
          canLName: '',
          canEmail: '',
          canAbout: '',
          canEducation: '',
          canEmploy: '',
          canExp: '',
          canCon: ''
        },
      }  
    },  

computed: {
  /**voterCandidateHeader() is computed data to return the current electionID that
   * is displayed in the data card title
   * @return - returns "Election ID: "" and the current election ID
   */

},

created: function(){
  this.$log.debug("Setting election Data:")
    //sets the current election ID that is pulled from the route/URL
    this.currentCan = this.$route.params.eID
    this.$log.debug("Getting election:")

     this.$log.debug("Created:")
},

mounted: function(){

  this.$log.debug("Mounted:")
  //sets the userObj object from the parent userObj
  this.userObj = this.$parent.$parent.userObj
},

computed: {
  /**voterCandidateHeader() is computed data to return the current electionID that
   * is displayed in the data card title
   * @return - returns "Election ID: "" and the current election ID
   */
  voterCandidateHeader(){
    return this.form.canFname + this.form.canLName;
  },
  /**voterCandidateSub() is computed data to return the current electionID that
   * is displayed in the data card sub title
   * @return - returns the current election Title
   */
  voterCandidateSub(){
    return this.form.canCon;
  }
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

}
}
</script>
