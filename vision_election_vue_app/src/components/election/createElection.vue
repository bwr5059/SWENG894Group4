<template>
  <div>
    <div>
        <div class="d-flex justify-content-center mb-3">
          <b-spinner v-if="!show" label="Loading..."></b-spinner>
        </div>
      </div>
    <b-container v-if="show">
    <b-row class ='d-flex justify-content-center'>
    Create an election
    </b-row>
    
    <b-form>
      <b-form-group id="input-group-1" label="Election ID:" label-for="input-1">
        <b-form-input
          id="input-1"
          
          readonly
          v-model="electionId"
          
        ></b-form-input>
      </b-form-group>
      
      <b-form-group id="input-group-2" label="Election Title:" label-for="input-2">
        <b-form-input
          id="input-2"
          
          required
          placeholder="Enter title"
          v-model='form.electionTitle'
        ></b-form-input>
      </b-form-group>
    
      <b-form-group id="input-group-3" label="Election Description:" label-for="input-3">
        <b-form-input
          id="input-3"
          
          required
          placeholder="Enter Description"
          v-model='form.electionDescription'
        ></b-form-input>
      </b-form-group>

        
      <b-form-group id="input-group-2" label="Election Key:" label-for="input-2">
        <b-form-input
          id="input-2"
          
          required
          placeholder="Enter Election key"
          v-model='form.electionKey'
        ></b-form-input>
      </b-form-group>

      <b-row>
          <b-col>
          <b-form-group id="input-group-5" label="Start Date:" label-for="input-5">
            <b-form-input
              id="input-4"
              type="date"
              required
              v-model='form.electionStartDate'
              
            ></b-form-input>
          </b-form-group>
          </b-col>
          <b-col>
          <b-form-group id="input-group-6" label="Close Date:" label-for="input-6">
            <b-form-input
              id="input-4"
              type="date"
              required
              v-model='form.electionEndDate'
            ></b-form-input>
          </b-form-group>
          </b-col>
        </b-row>
  
      <b-button v-on:click="updateElection" class="mr-1">Create</b-button>
      <b-button v-on:click="deleteElection">Cancel</b-button>

    </b-form>
    </b-container>
  </div>
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
    electionId: '',
    form: {
    electionTitle: '',
    electionDescription: '',
    electionKey:'',
    electionStartDate: '',
    electionEndDate: '',
    },
    error: '',
    authorized: false,
    show: false
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
      this.electionId = this.electionObj.data.electionID
      this.show=true
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to add todo"  
  }); 
  
      },
      updateElection: function(){
        api.updateElection(this.form.electionTitle, this.form.electionDescription, this.form.electionStartDate, this.form.electionEndDate, this.electionId,this.form.electionKey).then( (response) => {  
      this.$log.debug("Election updated:", response);  
      this.electionObj = response
      alert("Election Created")
      this.$router.push({ path: '/app/user/home' }) 
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed update election"  
      });
      
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