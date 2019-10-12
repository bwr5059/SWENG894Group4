<template>
  <div>
    Candidates
    <b-table striped hover :items="items" selectable select-mode="single" @row-selected="selected" ref="selectableTable" :fields='fields' :busy="isBusy">
      <template v-slot:table-busy>
        <div class="text-center text-dark my-2">
          <b-spinner class="align-middle"></b-spinner>
          <strong>Loading...</strong>
        </div>
      </template>
    </b-table>
  </div>
</template>

<script>

import api from '@/apis/candidateApi'
  export default {
      name: 'candidates',
    data() {
      return {
        items: null,
        selecteditem: null,
        data: null,
        isBusy: true,
        fields: ['first_name', 'last_name', 'about', 'education', 'employment','experience','contact'],
      }
    },


    mounted: function(){

        this.getCandidates()
    },
    methods: {

    async refreshData () {  
      this.currentCandidateData = this.$route.params.cID
      this.getCandidate(this.currentCandidateData)
      
    },  

    getCandidates: function(){
        api.getCandidates().then( (response) => {  
      this.$log.debug("Success getting candidates:", response);  
      this.items = response.data._embedded.candidates;
      this.isBusy=false
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to get candidates"  
	});  
    },

    selected: function(items){
      this.selecteditem = items
      //alert(' hello world'+this.selecteditem[0].last_name);
      this.$router.push({path: `/app/home/Candidate/${this.selecteditem[0].last_name}/details`})
   
  
    }
}
  }
</script>