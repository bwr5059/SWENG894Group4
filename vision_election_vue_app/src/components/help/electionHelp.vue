<template>
    <div>
    <center><h1 class="display-7">Election Help Page</h1></center>
    
  <div role="tablist">
    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-1 variant="info">Election Overview Page</b-button>
      </b-card-header>
      <b-collapse id="accordion-1" visible accordion="my-accordion" role="tabpanel">
        <b-card-body>
          
          <b-card-text>
         <p> The election overview page is the default page that the election administrator will see
          when accessing an election.
          This page gives a high-level overview/snapshot of the election based on its current state:</p>
<ul>
<li>The dates of the election shown in the time zone set in the election’s date settings.</li>
<li>The Voting URLs section.</li> 
<li>A count of the total number of voters, and candidates in the election.</li>
</ul>
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-2 variant="info">How to Create an Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
        <p> The first step to create an election is to create an account. 
         If you already have an account, visit your account dashboard on the Administrator page and 
         click on “+ New Election”. Note that the values provided for the fields (title, start date, 
         end date, time zone) can be updated after creating the election by visiting the election’s 
         settings page. Administrator has to:</p>
 <ul>        
<li> Click on the New Election button on Administrator page. A new election is created, and a unique election id is assigned.</li> 
<li> Enter: a descriptive title for the election, start date, end date, time zone the beginning and end time for the election.</li>  
<li> Enter other election info (e.g. election name, a detailed description of election, election type etc.).</li> 
<li> Click on “Save Election” and you will be redirected to the Election Overview Page </li> 
 </ul>
<p> Additional Notes</p>
<ul>
<li>Elections will not automatically start until it has been launched. Once launched, the election will automatically start and end on the set date/time.</li>
</ul>

          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-3 variant="info">How to Launch an Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-3" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
        <p> All elections created on Vision Election will start in the “Building” state and will not start until the election administrator launches the election by going through the launch process. The launch process consists of 4 steps:</P>
       <ol> 
      <li>	Confirm Election Details</li>
      <li>	Check Election Ballot</li>
      <li>	Terms of Service</li>
       </ol>
<p>To start the election launch process, click on “Launch” on the election sidebar. Elections can only be launched if they’re in the “Building” state.</P>  
 <p><b>1. Confirm Election Details</b></p>
 <p>The first step of the launch process is used to verify that the election’s details (title, dates, timezone, settings, etc.) are correct. Reference the permissions matrix to see which settings can modified once the election has been launched.</P>
 <p>Launch Requirements:</P>
 <p>Elections must meet the following requirements before they can move to step 2 of the launch process:</p>
 <ul>
 <li>The ballot must have at least two candidates.</li> 
<li>The election must have at least 1 registered voter.</li> 
<li>The election’s end date must be in the future.</li> 
</ul>
<p>Click “Continue” after verifying the election’s details and that the launch requirements have been met.</p>
<p><b>2. Check Election Ballot</b></p> 
<p>Assuming the launch requirements have been met, the next step in the launch process requires that the election administrator confirms that the ballot is set up correctly. This step is crucial because the ballot of an election cannot be modified once the election has been launched. 
This is to protect the integrity of the election and no exceptions can be made.</P>
<p>After verifying the ballot details, check the “I understand…” checkbox (1) and click “Continue” (2).</p>
<p><b> 3. Terms of Service</b></P>
<p>The third step of the launch process requires that the election administrator agrees to Election Runner’s Terms of Service, Privacy Policy,
 and that it understood which changes can and cannot be made to a running election.</p>
 <p>To continue to the final step of the launch process, check the “I understand…” checkbox (1) and click “Continue” (2).</p>    
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>


      
    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-4 variant="info">How to Modify the Ballot of a Running Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-4" visible accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
          <p>The ballot of an election that has been launched cannot be modified. 
          This is to protect the integrity of the election and no exceptions will be made.
           When launching an election, election administrators are required to check the ballot and 
           confirm that they understand changes cannot be made to the ballot.</P>
           <p>If changes need to be made to the ballot, then follow the steps below:</p>
           <ul>
<li>	Close the election.</li>
<li>	Duplicate the election to create a new election with the same voters list, ballot, and settings.</li> 
<li>	Modify the ballot with the necessary changes.</li>
<li>	Go through the launch process (see: How to Launch an Election).</li>
</ul>

          
          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-5 variant="info">How to Preview an Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-5" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
      
          <p>When building an election, the election administrator has the ability to preview and 
          vote in the election exactly as a voter would when the election is running. 
          In order to preview an election, the following requirements must be met:</p>

    <ul>
<li>The ballot must have at least one Candidate.</li>
<li>The election must be in the “Building” state (see: Election States).</li>
    </ul>
          <p>Assuming the above requirements are met, 
          the election can be previewed by following the steps below:</p>
      <ol>
<li>Click on “Preview” on the election sidebar.</li>
<li>Click on the “Continue” button.</li> 
<li>After clicking on “Continue”, click on the newly added button “Launch Election Preview” to launch the voting application in a new browser window.</li> 
<li>Login to the election using test as the Voter ID. Ballots submitted while previewing the election will not count towards the election’s results.</li>
      </ol>
    
 
          
          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-6 variant="info">How to Share the Election Preview with Others</b-button>
      </b-card-header>
      <b-collapse id="accordion-6" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
         <p>In some cases, the election administrator may need to allow additional election stakeholders to proof the election and verify that the ballot is set up correctly prior to launching the election. Instead of sharing login credentials with these stakeholders, 
         election administrators can share the election preview URL by following the steps below:</P> 

      <ol>
<li>Click on “Preview” on the election sidebar.</li>
<li>Click on the “Continue” button.</li> 
<li>Click on the newly added button “Show”.</li>
<li>The public preview URL will now be visible. This URL can be shared with anyone.</li>
      </ol>
         <p><b>Additional Notes</b></p>
      <ul>
<li>Login to the election using test as the Voter ID.</li>
<li>Ballots submitted by test voters will not count towards the election’s results.</li>
<li>The election can only be previewed while the election is in the “Building” state. The preview link will not work after the election has been launched.</li>
<li>Access to the public preview URL cannot be revoked. This URL will be accessible by anyone with the URL.</li>
     </ul>
          
          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>


       <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-7 variant="info">Introduction to the Election Builder Interface</b-button>
      </b-card-header>
      <b-collapse id="accordion-7" visible accordion="my-accordion" role="tabpanel">
        <b-card-body>
         <b-card-text>
         
         <p>The election builder interface is where the election administrator will manage all aspects of a given election.</p>
         <p><b>Header</b></p>
         <p>The election header shows the title and status of the election.</p>
         <p><b>Sidebar</b></p>
         <p>The election sidebar provides election 
         administrators with an easy way to navigate to the different sections of an election.</p>
      
      <ul>
<li>Clicking on the Election Runner logo will result in navigating back to the account dashboard.</li>
<li>The election navigation includes all areas of the election that can be managed by the election administrator. The navigation will change based on the state of the election (see: Election states).</li>
<li>The election dates are displayed in the sidebar. The date/time is displayed using the time zone that is set in the election’s date settings. For example, if an election is set to US/Eastern, but the election administrator is viewing the election from a computer with the time zone set to US/Central, the date/time will show in US/Eastern time.</li> 
      </ul>
         
         </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-8 variant="info">The Different States of an Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-8" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
          <p>An election administered with Election Runner goes through 5 different states 
          (we may also refer to the state as an election’s status, stage, or mode):</p>

        <ol>
<li>Building</li>
<li>Scheduled</li>
<li>Running</li>
<li>Completed</li>
<li>Archived</li>
        </ol>
           <p><b>1. Building</b></p>
           <p>All elections start in the “Building” state. When an election is in the “Building” state, the election administrator can make any changes to the election’s configuration. This includes the election’s settings, the ballot, and the voters list. An election will remain in the “Building” 
           state until the election administrator goes through the Launch Process.</p>
           <p><b>Building Election Permissions</b></p>
           <p>The following summarizes the different actions an Election Administrator and 
           Voter can take while the election is in the “Building” state:</p>
         <ul>
<li>Update all election settings</li>
<li>Manage the voters list</li>
<li>Manage the ballot</li>
<li>Preview the election</li>
         </ul> 
           <p><b>Voters</b></p>
           <p>Voters cannot access an election that is in the “Building” state</p>

           <p><b>2. Scheduled</b></p>
           <p>On completion of the launch process, an election will enter the “Scheduled” state. 
           A “Scheduled” election will automatically start (change to the “Running” state) on the start date/time and time zone defined in the election settings. If the start date/time is set to a date/time and time zone that is in the past, 
           then the election will start within 2 minutes of completing the launch process.</p>
           <p><b>Scheduled Election Permissions</b></p>
           <p>The following summarizes the different actions an Election Administrator 
           and Voter can take while the election is in the “Scheduled” state:</p>
           <p><b>Election Administrators</b></p>
        <ul>
<li>Manage the voters list.</li>
<li>Update election settings under the General, Messages, and Email tabs.</li>
<li>View the ballot.</li>
        </ul>
           <p><b>Voters</b></p>
        <ul>
<li>Can access the election via the election’s URL but will not be able to login to the election or view the ballot.</li>
<li>Can see the election on the state’s landing page.</li> 
        </ul>

            <p><b>3. Running</b></p>
            <p>Once an election enters the “Running” state it has officially started. The election will automatically end on the date set in the settings unless the
             election administrator chooses to close the election before that date.</p>
             <p><b>Running Election Permissions</b></p>
             <p>The following summarizes the different actions an Election Administrator and 
             Voter can take while the election is in the “Running” state:</p>
             <p><b>Election Administrators</b></p>
          <ul>
<li>Can manage the voters list.</li> 
<li>View the ballot.</li> 
<li>View the results of the election.</li> 
<li>Update election settings under the General, Messages, Email tabs.</li> 
<li>Update the end date/time of the election.</li>  
<li>Close the election before the set end date/time.</li>  
<li>Send email reminders to voters.</li>  
<li>Re-send instructions to individual voters.</li> 
         </ul> 
             <p><b>Voters</b></p>
         <ul>
<li>Can now login to the election and submit their ballots.</li>
<li>Voters with an email address will receive an email with instructions on how to vote.</li> 
<li>Can see the election on the state’s landing page.</li>
        </ul> 
             
             <p><b>4. Completed</b></p>
             <p>Elections enter the “Completed” state when the election administrator closes 
             the election or the election closes automatically on the end date.</p>
             <p><b>Completed Election Permissions</b></p>
             <p>The following summarizes the different actions an Election Administrator and 
             Voter can take while the election is in the “Completed” state:</P>
             <p><b>Election Administrators</b></p>
        <ul>
<li>View the results of the election (see: Election Results).</li>
<li>Export the results of the election (see: Export Election Results).</li>
<li>Publish the results of the election (see: How to Publish Election Results).</li>
<li>Export a Voter Audit report as a spreadsheet (see: Voter Audit Report).</li>
<li>Export Voter Activity Logs as a spreadsheet (see: Voter Activity Logs).</li>
<li>Export Voters as a spreadsheet (see: Export Voters).</li>
<li>View the ballot.</li>
<li>Archive the election (see: Archive an Election).</li>
       </ul>   
             <p><b>Voters</b></p>
       <ul>
<li>Can see the election on the state’s landing page.</li> 
<li>Can access election by visiting the election’s URL but will not be able to login. Voters will see the “After Election” message (see: Election Messages).</li>
<li>Can view election results if the results have been published by the election administrator (see: How to Publish Election Results).</li>
       </ul> 

             <p><b>5. Archived</b></p>
             <p>Archiving an election will result in the election being hidden from public view</p>
             <p><b>Archived Election Permissions</b></p>
             <p>The following summarizes the different actions an Election Administrator and 
             Voter can take while the election is in the “Archived” state:</p>
             <p><b>Election Administrators</b></p>
         <ul>
<li>View the results of the election (see: Election Results).</li>
<li>Export the results of the election (see: Export Election Results).</li>
<li>Publish the results of the election (see: How to Publish Election Results).</li>
<li>Export a Voter Audit report as a spreadsheet (see: Voter Audit Report).</li>
<li>Export Voter Activity Logs as a spreadsheet (see: Voter Activity Logs).</li>
<li>Export Voters as a spreadsheet (see: Export Voters)
<li>View the ballot.</li>
<li>Archive the election (see: Archive an Election).</li>
         </ul>
              <p><b>Voters</b></p>
              <p>Voters cannot access an “Archived” election</p>

           
        
          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>
  </div>



    </div>
</template>


<script>
export default {
  name: 'electionHelp',
  props: {
    msg: String
  }
}
</script>