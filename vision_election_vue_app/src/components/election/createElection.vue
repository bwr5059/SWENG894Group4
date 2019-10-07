<template>
    <b-container>
    <b-row class ='d-flex justify-content-center'>
    Create an election
    </b-row>
    
    <b-form>
      <b-form-group id="input-group-1" label="Election ID:" label-for="input-1">
        <b-form-input
          id="input-1"
          
          required
          v-model="electionID"
          
        ></b-form-input>
      </b-form-group>
      
      <b-form-group id="input-group-2" label="Election Title:" label-for="input-2">
        <b-form-input
          id="input-2"
          
          required
          placeholder="Enter title"
          v-model='electionTitle'
        ></b-form-input>
      </b-form-group>
    
      <b-form-group id="input-group-3" label="Election Description:" label-for="input-3">
        <b-form-input
          id="input-3"
          
          required
          placeholder="Enter Description"
          v-model='electionDescription'
        ></b-form-input>
      </b-form-group>
      <b-row>
          <b-col>
          <b-form-group id="input-group-5" label="Start Date:" label-for="input-5">
            <b-form-input
              id="input-4"
              type="date"
              required
              v-model='this.electionStartDate'
              
            ></b-form-input>
          </b-form-group>
          </b-col>
          <b-col>
          <b-form-group id="input-group-6" label="Close Date:" label-for="input-6">
            <b-form-input
              id="input-4"
              type="date"
              required
              v-model='this.electionEndDate'
            ></b-form-input>
          </b-form-group>
          </b-col>
        </b-row>
  
      <b-button v-on:click="updateElection" class="mr-1">Create</b-button>
      <b-button v-on:click="deleteElection">Cancel</b-button>

    </b-form>
    </b-container>
</template>


<script>

import api from '@/apis/electionApi'
export default {
  name: 'createElection',
  props: {
    msg: String,
    activeUser: null,
    
  },
   data: () => {  
      return {
    electionObj: null,
    electionTitle: '',
    electionDescription: '',
    electionId: '',
    electionStartDate: '',
    electionEndDate: '',
    error: '',
    authorized: false
      }
  },

  mounted: function(){
      this.createElection();

  },

  created(){
     
  },

  methods: {
      createElection: function(){
      
  
    api.createNew().then( (response) => {  
      this.$log.debug("New election created:", response);  
      this.electionObj = response
      this.electionId = this.electionObj.electionID
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to add todo"  
  }); 
  
      },

      updateElection: function(){
        api.updateElection(this.electionTitle, this.electionDescription, this.electionStartDate, this.electionEndDate, this.electionObj.data.electionId).then( (response) => {  
      this.$log.debug("Election updated:", response);  
      this.electionObj = response
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed update election"  
      });
      this.$router.push({ path: '/app/user/home' }) 
      },

      deleteElection: function(){
        api.removeElection(this.electionObj.data.electionID).then((response)=> {
          this.$log.debug("Election deleted:", response);
          
        })
        this.$router.push({ path: '/app/user/home' })
      }
  }
}
</script>