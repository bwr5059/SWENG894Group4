<template>
    <div class='d-flex justify-content-center'>
        <div class="container">
            <p>email: {{userEmail}} id: {{userID}} firstname: {{userFName}} lastname: {{userLName}}</p>
                <div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" v-model='this.activeUser.email' readonly>
                        
                    </div>
                    <div class="form-group">
                        <label for="fName">First Name:</label>
                        <input type="text" class="form-control" id="fName" placeholder="Enter First Name" name="fName" v-model='this.activeUser.given_name' readonly>
                    </div>
                    <div class="form-group">
                        <label for="lName">Last Name:</label>
                        <input type="text" class="form-control" id="lName" placeholder="Enter Last Name" name="lName" v-model='this.activeUser.family_name' readonly>
                    </div>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Dropdown button
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item">Action</a>
                            <a class="dropdown-item" >Another action</a>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="age">Age:</label>
                        <input type="text" class="form-control" id="age" placeholder="Enter Age" name="age">
                    </div>
                    <div class="form-group">
                        <label for="ethnicity">Ethnicity:</label>
                        <input type="text" class="form-control" id="ethnicity" placeholder="Enter Your Ethnicity" name="ethnicity">
                    </div>
                    <div class="form-group">
                        <label for="gender">Gender:</label>
                        <input type="text" class="form-control" id="gender" placeholder="Enter Your Gender" name="gender">
                    </div>
                    <button class="btn btn-default" v-on:click="addUser">Submit</button>
                </div>
        </div>
   

       

  
    </div>

    
</template>


<script>
import api from '@/apis/userApi'

export default {
  name: 'profile',
  props: {
    msg: String,
    activeUser: Object
  },
  data: () => {  
      return {  
        activeUser: null,
        userData: {
            uEmail: '',
            fName: '',
            lName: '',
            uId: '',
        },
      }  
    },  


    

    computed: {
        userEmail: function () {
        return this.activeUser ? this.activeUser.email : ''
    },

        userID: function () {
        return this.activeUser ? this.activeUser.sub : ''
    },
        userFName: function () {
        return this.activeUser ? this.activeUser.given_name : ''
    },
        userLName: function () {
        return this.activeUser ? this.activeUser.family_name : ''
    },
    },

     async created () {  
    await this.refreshActiveUser()  
  },  
  
  watch: {  
    '$route': 'refreshActiveUser'  
  },  
  
  methods: {  
    async refreshActiveUser () {  
      this.activeUser = await this.$auth.getUser()  
      this.$log.debug('activeUser',this.activeUser)  
    },  
  
    async handleLogout () {  
      await this.$auth.logout()  
      await this.refreshActiveUser()  
      this.$router.go('/')  
    },

    addUser: function () {  
        window.alert("5", this.activeUser.email, this.activeUser.given_name, this.activeUser.family_name, "Voter", document.getElementById("age").value,
    document.getElementById("ethnicity").value, document.getElementById("gender").value, "true" )
  
    api.createNew(5, this.activeUser.email, this.activeUser.given_name, this.activeUser.family_name, "Voter", document.getElementById("age").value,
    document.getElementById("ethnicity").value, document.getElementById("gender").value, "true" ).then( (response) => {  
      this.$log.debug("New item created:", response);  
	   
    }).catch((error) => {  
      this.$log.debug(error);  
	  this.error = "Failed to add todo"  
	});  
  
   
  },  
  



  
  },
}
</script>