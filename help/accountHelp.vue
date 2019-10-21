<template>
    <div>
    <center><h1 class="display-7" >Account Help Page</h1></center>

    <div role="tablist">

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-1 variant="info">About the Vision Election System</b-button>
      </b-card-header>
      <b-collapse id="accordion-1" visible accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
The Vision Election system application is available as a free download on iTunes & Google Play. The purpose of the application is to provide voters with a secure voting software for the management of complex municipal, state and federal elections. 

          </b-card-text>
          
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-2 variant="info">The Election Landing Page</b-button>
      </b-card-header>
      <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>Every state or level of government with a Vision Election System account is provided with a designated “landing page” that acts as a centralized hub for that state or arm of government’s elections. This landing page displays the name of the state, the arm of government and logos or flags, as well as a list of elections that are currently accessible to voters.
Only elections in the “Scheduled”, “Running” or “Completed” state will be listed on the state’s landing page.</b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-3 variant="info">How to Set Up the State/Federal Landing Page</b-button>
      </b-card-header>
      <b-collapse id="accordion-3" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>The state or federal landing page can be accessed after setting up a “subdomain” under the state’s settings.  For example, if the state is “Texas.”, you would likely want to set the subdomain to as Texas. Resulting in the URL of your landing page being https://texas.visionelectionsystem.com. This feature allows each state or Federal government of the United States of America to provide voters with a simple and branded URL that they can access and see the state’s landing page.
If a state has only one election and that election is in the “Running” state then voters will be automatically be redirected to that election’s login page. Otherwise, they will see a list of elections that meet the previously mentioned criteria and will have to click on the election they want to access.</b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

        <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-4 variant="info">Password Recovery</b-button>
      </b-card-header>
      <b-collapse id="accordion-4" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
            <p>To recover your password on the Vision Election System, navigate to login page and follow the steps below:     </p>

<ul>
  <li>Select “Forgot Password.”</li>
  <li>Enter your username.</li>
  <li>You will be sent an email with correct password. </li>
</ul>

          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

        <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-5 variant="info">How to Change your Password</b-button>
      </b-card-header>
      <b-collapse id="accordion-5" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
<p>Follow the steps below to change your account password:</p>
<ul>
<li>Login to Vision Election System and Click on “Settings” at the top of your account dashboard.</li>
<li>Click on “Change Password” link.</li>
<li>Enter your current password, the new password, and then the new password again (in the Confirm Password field).</li>
<li>Click “Save Changes.”</li>
</ul>

          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

           <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-6 variant="info">User ID Recovery</b-button>
      </b-card-header>
      <b-collapse id="accordion-6" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
<p>To recover your user ID on the Vision Election System, navigate to login page and follow the steps below:</p>
<ul>
<li>Click on recover user ID at the top of your account dashboard.</li>
<li>Enter your valid email address and security question answer. </li>
<li>Click on “Submit.”</li>
<li>You will be sent an email with correct user ID. </li>
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
  name: 'accountHelp',
  props: {
    msg: String
  }
}
</script>