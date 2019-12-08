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
The Vision Election system application can be accessed through any web browser and smart phone. The
purpose of the application is to provide voters with a secure voting software for the management of
complex municipal, state, federal elections and student electoral bodies.
          </b-card-text>
          
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-2 variant="info">The Landing Page</b-button>
      </b-card-header>
      <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
            Every state or level of government with a Vision Election System account is provided with a designated
“landing page” that acts as a centralized hub for that state or arm of government’s elections. 
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-3 variant="info">How to Sign Up</b-button>
      </b-card-header>
      <b-collapse id="accordion-3" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
            
<p>To create an account, follow the steps below:</p>
<ul>
    <li>Click on the “Login” button on the navigation bar on the homepage.</li>
<li>Click on “Sign up” below.</li>
<li>Fill out the information in the visible form fields.</li>
<li>Click on “Register.”</li>
</ul>
</b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

 <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-31 variant="info">How to  Log In</b-button>
      </b-card-header>
      <b-collapse id="accordion-31" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
            
<p>To create an account, follow the steps below:</p>
<ul>
<li>Click on the “Log In” button on the navigation bar on the homepage.</li>
<li>Enter username and password.</li>
<li>Click on “Sign In.”</li>
</ul>
</b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>


        <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-4 variant="info">Password Recovery*</b-button>
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
        <b-button block href="#" v-b-toggle.accordion-5 variant="info">How to Change your Password*</b-button>
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
        <b-button block href="#" v-b-toggle.accordion-6 variant="info">Username Recovery*</b-button>
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

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-7 variant="info">How to View the Contact/Support Page</b-button>
      </b-card-header>
      <b-collapse id="accordion-7" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
<ul>
<li>Click on the “Contact” tab on the navigation bar.</li>
<li>Fill out the information in the visible form fields. </li>
<li> Click on “Send Message”.</li>
<li>Click on “OK” on the pop-up modal dialog.
 </li>
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