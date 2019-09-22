<template>
<div>


<b-card>
<b-row>

<div>ID: {{this.data.data.electionId}}</div>


</b-row>
<b-row>
    Election Title: {{this.data.data.title}}

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
        data: null,
        error: ''
      }  
    },  

created: function(){
    this.currentElectionData = this.$route.params.eID
    this.getElection(this.$route.params.eID);
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
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to get election"  
	});  
    }
  

}
}
</script>
