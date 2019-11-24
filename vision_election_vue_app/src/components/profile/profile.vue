<template>
<div class='d-flex justify-content-center'>
  <div class="container">
    <div>
      <header>
        <strong>Profile:</strong>
      </header>
      <div class="text-center text-dark my-2" v-if="!show">
        <b-spinner class="align-middle"></b-spinner>
        <strong>Loading...</strong>
      </div>  
      <b-form v-if="show" fluid>
        <b-row>
          <b-col>
            <b-form-group
              id="input-group-1"
              label="Email address:"
              label-for="input-1"
            >
            <b-form-input
              id="input-1"
              v-model="this.$parent.activeUser.email"
              type="email"
              required
              readonly
            ></b-form-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group id="input-group-11" label="Type:" label-for="input-11">
            <b-form-select
              id="input-11"
              v-model="form.type"
              :options="type"
              required
              :disabled="!editable"
            ></b-form-select>
            </b-form-group>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
          <b-form-group id="input-group-2" label="First Name:" label-for="input-2">
            <b-form-input
              id="input-2"
              v-model="this.$parent.activeUser.given_name"
              required
              placeholder="Enter first name"
              readonly
            ></b-form-input>
          </b-form-group>
          </b-col>
          <b-col>
          <b-form-group id="input-group-3" label="Last Name:" label-for="input-3">
            <b-form-input
              id="input-3"
              v-model="this.$parent.activeUser.family_name"
              required
              placeholder="Enter last name"
              readonly
            ></b-form-input>
          </b-form-group>
          </b-col>
          <b-col>
          <b-form-group id="input-group-4" label="Age:" label-for="input-4">
            <b-form-input
              id="input-4"
              v-model="form.age"
              required
              placeholder="Enter age"
              :disabled="!editable"
            ></b-form-input>
          </b-form-group>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
          <b-form-group id="input-group-5" label="Race:" label-for="input-5">
            <b-form-select
              id="input-5"
              v-model="form.race"
              :options="race"
              required
              :disabled="!editable"
            ></b-form-select>
          </b-form-group>
          </b-col>
          <b-col>
          <b-form-group id="input-group-6" label="Ethnicity:" label-for="input-6">
            <b-form-select
              id="input-6"
              v-model="form.ethnicity"
              :options="ethnicity"
              required
              :disabled="!editable"
            ></b-form-select>
          </b-form-group>
          </b-col>
          <b-col>
          <b-form-group id="input-group-7" label="Gender:" label-for="input-7">
            <b-form-select
              id="input-7"
              v-model="form.gender"
              :options="gender"
              required
              :disabled="!editable"
            ></b-form-select>
          </b-form-group>
          </b-col>
        </b-row>
        <b-form-group id="input-group-8" label="Street Address:" label-for="input-8">
          <b-form-input
            id="input-8"
            v-model="form.address"
            required
            placeholder="Enter street address"
            :disabled="!editable"
          ></b-form-input>
        </b-form-group>
        <b-form-group id="input-group-12" label="City:" label-for="input-12">
          <b-form-input
            id="input-12"
            v-model="form.city"
            required
            placeholder="Enter city"
            :disabled="!editable"
          ></b-form-input>
        </b-form-group>
        <b-form-group id="input-group-9" label="State:" label-for="input-9">
          <b-form-input
            id="input-9"
            v-model="form.state"
            required
            placeholder="Enter state"
            :disabled="!editable"
          ></b-form-input>
        </b-form-group>
        <b-form-group id="input-group-10" label="Zip Code:" label-for="input-10">
          <b-form-input
            id="input-10"
            v-model="form.zip"
            required
            placeholder="Enter zip code"
            :disabled="!editable"
          ></b-form-input>
        </b-form-group>
        <b-button v-show="!editable" v-on:click="edit">Edit</b-button>
        <b-button v-show="editable" class="mr-1" v-on:click="cancel">Cancel</b-button>
        <b-button v-show="editable" v-on:click="addUser">Submit</b-button>
      </b-form>
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
    //activeUser: Object
  },
  data: () => {  
      return {  
        activeUser: null,
        //form data for user information
        form: {
          email: '',
          fname: '',
          lname: '',
          age: '',
          gender: null,
          race: null,
          ethnicity: null,
          address: '',
          city: '',
          state: '',
          zip: '',
          type: null
        },
        //list data for form data selection
        gender: [{ text: 'Select One', value: null }, 'Male', 'Female', 'Not Disclosed'],
        race: [{text: 'Select one', value: null}, 'American Indian or Alaska Native', 'Asian', 'Black or African American', 'Native Hawaiin or Other Pacific Islander', 'White'],
        ethnicity: [{text: 'Select One', value: null}, 'Hispanic or Latino or Spanish Origin', 'Not Hispanic or Latino or Spanish Origin'],
        type: [{text: 'Registration Type', value: null}, 'Voter', 'Candidate', "Admin"],
        //variables to enable displaying and editing
        show: false,
        editable: false,
        //variables to hold user object and profile completion
        userObj: '',
        userProfileComplete: 0
      }  
    },  
    /**
     * mounted calls the getUser API call to return user data.  Some data is returned from the active
     * user data from the okta api.
     */
    mounted: function(){
      this.activeUser = this.$parent.activeUser,
      api.getUser(this.activeUser.sub)  
      .then(response => {  
        this.$log.debug("Data loaded: ", response.data)
        this.userObj = response
        this.form.email = this.$parent.activeUser.email
        this.form.type = this.userObj.data.type
        this.form.fname = this.$parent.activeUser.given_name
        this.form.lname = this.$parent.activeUser.family_name
        this.form.age = this.userObj.data.age
        this.form.race = this.userObj.data.race
        this.form.ethnicity = this.userObj.data.ethnicity
        this.form.gender = this.userObj.data.gender
        this.form.address = this.userObj.data.address
        this.form.city = this.userObj.data.city
        this.form.state = this.userObj.data.state
        this.form.zip = this.userObj.data.zip 
        if(this.userObj!=""){
          this.userProfileComplete = 1
          this.show=true
        }else{
          this.userProfileComplete = 0
        } 
      })
    },
    /**
     * created call the refreshActiveUser() function to refresh the active user from okta.
     */
    async created () {  
    await this.refreshActiveUser()  
    },  
    /**
     * watch actively listens to route object and anytime the route changes, it triggers
     * the refreshActiveUser function.
     */
    watch: {  
      '$route': 'refreshActiveUser'  
    },  
  
    methods: {  
      /**
       * refreshActiveUser() function calls the getUser api call from the okta user object.
       */
      async refreshActiveUser () {  
        this.activeUser = await this.$auth.getUser()  
        this.$log.debug('activeUser',this.activeUser)
      },  
      /**
       * handleLogout() function forces a redirect to the main page and calls the okta logout api call.
       */
      async handleLogout () {  
        await this.$auth.logout()  
        await this.refreshActiveUser()  
        this.$router.go('/')  
      },
      /**
       * edit() enables editing of the form data for user information.
       */
      edit: function(){
          this.editable=true
      },
      /**
       * cancel() disables editing.
       */
      cancel: function(){
          this.editable=false
      },
      /**
       * addUser() function calls the api to either create a new user entry in the application based on the
       * userProfileComplete variable.  If the variable is set to 1, then it calls the modify api call.
       */
      addUser: function () {  
          window.alert("Subbmiting to API")
          if(this.userProfileComplete==0){
          api.createNew(this.activeUser.sub, this.activeUser.email, this.form.type, this.activeUser.given_name, this.activeUser.family_name, this.form.age, this.form.race, this.form.ethnicity, this.form.gender, this.form.address, this.form.city, this.form.state, this.form.zip, this.activeUser.email).then( (response) => {  
            this.$log.debug("New User created:", response); 
            alert("Profile Updated") 
            this.$router.push({ path: '/app/user/home' })
          }).catch((error) => {  
            this.$log.debug(error);  
            this.error = "Failed to create"  
          });
          } else{
            api.modifyUser(this.userObj.data.id, this.form.email, this.form.type, this.form.fname, this.form.lname, this.form.age, this.form.race, this.form.ethnicity, this.form.gender, this.form.address, this.form.city, this.form.state, this.form.zip, this.activeUser.email).then( (response) => {  
              this.$log.debug("User Updated:", response); 
              alert("Profile Updated")
              this.$router.push({ path: '/app/user/home' })
            }).catch((error) => {  
              this.$log.debug(error);  
              this.error = "Failed to update"  
            });
          }
      },  
    },
}
</script>