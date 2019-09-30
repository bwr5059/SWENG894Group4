<template>
    <div>
    <center><h1 class="display-7">Voters Help Page</h1></center>

<div role="tablist">
    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-1 variant="info">How to Register to Vote</b-button>
      </b-card-header>
      <b-collapse id="accordion-1" visible accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>

            <p>To register to vote in an upcoming election, follow thee steps:</p>
<ul>

<li>Click on “Register.”</li>
<li>Click on “Type.” And chose Voter</li>
<li>Enters a username, password, first name, last name, and email etc.</li>
<li>Click on “Save.”</li>
<li>The information is saved, the account is created, and permissions are set.</li>

</ul>
 


          </b-card-text>
          
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-2 variant="info">How to Verify That You Are A Registered Voter</b-button>
      </b-card-header>
      <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>

<p>To verify that you are validly registered voter in an upcoming election, follow thee steps:</p>
<ul>
  <li>Login using Voter ID and password.</li>
  <li>Select available election.</li>
  <li>The System will display an appropriate ballot containing all elections for which you can vote from all levels of the election hierarchy (i.e. national, state, county, city, etc.).</li>
</ul>
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-3 variant="info">How to Cast Vote</b-button>
      </b-card-header>
      <b-collapse id="accordion-3" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
            <p>To cast a vote in an election, follow these steps:</p>
            <ul>
<li>Login using Voter ID and password.</li>
<li>Click on the election you wish to cast a vote from the list. </li>
<li>Click on “Open.”</li>
<li>View the candidates and instructions for the election.</li>
<li>Click on the candidate you choose to vote for. </li>
<li>Click on “Submit.”</li>
<li>Click on “Yes” to confirm that you want to submit the Vote. </li>
</ul>
          </b-card-text>
        </b-card-body>
         </b-collapse>
    </b-card>

         <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-4 variant="info">How to Change Profile Information</b-button>
      </b-card-header>
      <b-collapse id="accordion-4" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
<p>To change/edit profile information, do the following:</p>
<ul>
<li>Login using Voter ID and password.</li>
<li>On profile page, select edit.</li>
<li>Update or edit the information in the visible form fields.</li>
<li>Click on “Submit.”            </li>
</ul>
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>



  </div>

    </div>
</template>


<script>
export default {
  name: 'votersHelp',
  props: {
    msg: String
  }
}
</script>