<template>
<div>


<b-card v-show="this.$parent.$parent.authorized">
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
          :disabled="!editable"
        ></b-form-input>
      </b-form-group>
      </b-col>
      </b-row>
      <b-row>
        <b-col>
        <b-form-group id="input-group-4" label="Close Date:" label-for="input-4">
          <b-form-input
            id="input-4"
            type="date"
            required
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
<b-card>
<b-row>
  <b-col>
    Election ID: {{this.form.electionId}}
  </b-col>
  <b-col>
    Election Title: {{this.form.electionTitle}}
  </b-col>
  <b-col>
    Election Description: {{this.form.electionDescription}}
  </b-col>
  
</b-row>
<b-row>
 <br>
</b-row>
<b-row>

<b-button v-show="!editable" class="ml-1">Register</b-button>
</b-row>
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
        show: true,
        editable: false,
        form: {
          electionId: '',
          electionTitle: '',
          electionDescription: '',
        },
      }  
    },  

created: function(){
  this.$log.debug("Setting election Data:")
    this.currentElectionData = this.$route.params.eID
    this.$log.debug("Getting election:")
    this.getElection(this.$route.params.eID);
     this.$log.debug("Created:")
},

mounted: function(){
  // this.currentElectionData = this.$route.params.eID
  //   this.getElection(this.$route.params.eID);
  this.$log.debug("Mounted:")
  this.userObj = this.$parent.$parent.userObj
//  this.getElection(this.currentElectionData);
 
  
},

watch: {
    '$route': 'refreshData' 
},

methods: {

    async refreshData () {  
       this.$log.debug("Refreshing data:")
      this.currentElectionData = this.$route.params.eID
      this.getElection(this.currentElectionData)
      
    },  

    getElection: function(id){
      this.$log.debug("Calling API:")
      api.getElection(id).then( (response) => {  
      this.$log.debug("Success getting election:", response);  
      this.data = response
      this.form.electionId = this.data.data.electionId
      this.form.electionTitle = this.data.data.title
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to get election"  
	});  
    },

    edit: function(){
    
    this.editable=true

    },

    cancel: function(){
    
    this.editable=false

    },

    updateElection: function(){
      api.updateElection(this.form.electionTitle, this.form.electionDescription, this.form.electionId).then((response)=>{
        this.$log.debug("Updated election", response)
      }).catch((error)=>{
        this.$log.debug(error)
      })
      this.$router.push({ path: '/app/user/home' })
    }
  

}
}
</script>
