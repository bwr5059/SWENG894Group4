<template>
    <b-container>
    <b-row class ='d-flex justify-content-center'>
    Create an election
    </b-row>
    
    <b-form>
      
      <b-form-group id="input-group-2" label="Election Title:" label-for="input-2">
        <b-form-input
          id="input-2"
          
          required
          placeholder="Enter title"
          readonly
        ></b-form-input>
      </b-form-group>
    
      <b-form-group id="input-group-3" label="Election Description:" label-for="input-3">
        <b-form-input
          id="input-3"
          
          required
          placeholder="Enter Description"
          readonly
        ></b-form-input>
      </b-form-group>
    
  
      <b-button v-on:click="createElection">Create</b-button>

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

  mounted: function(){
      this.createElection();

  },

  created(){
     
  },

  methods: {
      createElection: function(){
           window.alert("Subbmiting to API")
  
    api.createNew().then( (response) => {  
      this.$log.debug("New item created:", response);  
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to add todo"  
	});  
      }
  }
}
</script>