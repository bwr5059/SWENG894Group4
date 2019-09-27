<template>
    <div>
    <center><h1 class="display-7">Candidate Help Page</h1></center>

 <div role="tablist">
    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-1 variant="info">How to Register as A Candidate in An Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-1" visible accordion="my-accordion" role="tabpanel">
        <b-card-body>
          
          <b-card-text>
<p>To register as a candidate in an upcoming election, follow thee steps:</p>
<ul>
  <li>Click on “Register.”</li>
  <li>Click on “Type.” And chose Candidate</li>
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
        <b-button block href="#" v-b-toggle.accordion-2 variant="info">How to Withdraw Candidacy from Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
            <p>To withdraw candidacy from an election, follow these steps:</p>
<ul>
  <li>Login using Candidate ID and password.</li>
  <li>Click on “Profile.”</li>
  <li>Click on “Election page:”</li>
  <li>Click on “View Current Election.”</li>
  <li>Selects election in which the candidate is to be removed.</li>
  <li>Click on “Withdraw Candidacy.”</li>
  <li>Click on “Yes.’</li>
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
  name: 'candidateHelp',
  props: {
    msg: String
  }
}
</script>