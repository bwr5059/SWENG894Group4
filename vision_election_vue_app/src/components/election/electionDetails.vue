<template>
<div>


<b-card>
<!-- <b-row>

<div>ID: {{this.data.data.electionId}}</div>


</b-row>
<b-row>
    Election Title: {{this.data.data.title}}

</b-row> -->
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
      <b-button v-show="!this.data.data.closed&!editable" class="ml-1">Register</b-button>
    </b-form>
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
        data: null,
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
    this.currentElectionData = this.$route.params.eID
    this.getElection(this.$route.params.eID);
    
},

mounted: function(){
  this.userObj = this.$parent.$parent.userObj
 // this.getElection(this.currentElectionData);
 
  
},

watch: {
    '$route': 'refreshData' 
},

methods: {

    async refreshData () {  
      this.currentElectionData = this.$route.params.eID
      this.getElection(this.currentElectionData)
      
    },  

    getElection: function(id){
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
        this.$log.debug("Updated election")
      }).catch((error)=>{
        this.$log.debug(error)
      })
      this.$router.push({ path: '/app/user/home' })
    }
  

}
}
</script>
