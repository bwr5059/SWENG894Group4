<template>
  <div>
    <b-table striped hover :items="items"></b-table>
  </div>
</template>

<script>

import api from '@/apis/electionApi'
  export default {
      name: 'elections',
    data() {
      return {
        items: null,
        
        data: null
      }
    },


    mounted: function(){

        this.getElections()
    },
    methods: {

    async refreshData () {  
      this.currentElectionData = this.$route.params.eID
      this.getElection(this.currentElectionData)
      
    },  

    getElections: function(){
        api.getElections().then( (response) => {  
      this.$log.debug("Success getting election:", response);  
      this.items = response.data
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to get elections"  
	});  
    }
  

}
  }
</script>