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

         <p>The election overview page is the default page that the election administrator will see when accessing an
election. This page gives a high-level overview/snapshot of the election based on its current state:</p>
<ul>
<li>The Election ID;</li>
<li>The Election title: and</li> 
<li>The dates of the election shown: the start and close date of the elections.</li>
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
          
        <p> The first step to create an election is to create an account. If you already have an account, visit your
account dashboard on the Administrator page and click on “+ New Election”. Note that the values
provided for the fields (title, start date, end date, time zone) can be updated after creating the election by
visiting the election’s settings page. Administrator has to:</p>
 <ul>        
<li> Click on the New Election button on Administrator page. A new election is created, and a unique election id is assigned.</li> 
<li> Enter: a descriptive title for the election, start date, end date, time zone the beginning and end time for the election.</li>  
<li> Click on “Create” and you will be redirected to the Election Overview Page. </li>

</ul>

          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-3 variant="info"> How to View Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-3" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
      <p> There are 2 options to view an election. The first option can only be used if you know the Election ID. If
you do not know the Election ID, use the second option.</p>

<p>For the first option, follow these steps:</p>
<ul>
<li>Login using your username and password.</li>
<li>Click on the drop-down select menu on the top right of the homepage, beside the search bar.</li>
<li>Select “Election”.</li>
<li>Type in the Election ID.</li>
<li>Click on “Search” button.</li>
</ul>
<p>For the second option, follow these steps:</p>
<ul>
<li>Click on “Search all” on the secondary navigation bar on the homepage.</li>
<li>Select the election you will like to view from the list.     </li>
</ul>
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>


      
    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-4 variant="info">How to Modify a Running Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-4" visible accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>

        <p>
          An election that is running <i>cannot be modified </i>. This is to protect the integrity of the election and no
exceptions will be made. When creating an election, the election administrators are required confirm that
they understand that changes cannot be made to the election. If changes need to be made to the election,
then the election must be duplicated. See How to Duplicate an Election Below
</p>  
        
          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-5 variant="info">How to View Progress/Prediction Reports of An Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-5" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
      
          <p>Vision Election System provides progress and prediction reports for every running election. Only the
voters and candidates have access to the election predictions and progress page. To view the
progress/prediction of a running election, follow the steps below:</p>

    <ul>
<li>Click on “Search All” on the navigation bar.</li>
<li>Select the election you wish to view its progress from the list on the election table.</li>
<li> Click on either the “Progress” or “Prediction” button. The progress or prediction chart will be
displayed. </li>
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
         <p><b>Navigation bar</b></p>
         <p>The election navigation bar provides election 
         administrators with an easy way to navigate to the different sections of an election.</p>
      
      <ul>
          <li>Clicking on “New” will start the creation of a new election.</li>
<li>Clicking on “Election Admin” will display the list of Admins, voters and candidates.</li>
<li>Clicking on “Search All” will display the list of all created elections.</li>
<li>Clicking on “Candidates” will display the list of all candidates, their educational background,
employment experience, contact details etc.</li>
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
        </ol>
           <p><b>1. Building</b></p>
           <p>All elections start in the “Building” state. When an election is in the “Building” state, the election
administrator can make any changes to the election’s configuration. This includes the election’s settings,
and the voters list. An election will remain in the “Building” state until the election is fully created.</p>
           <p><b>Building Election Permissions</b></p>
           <p>The following summarizes the different actions an Election Administrator and 
           Voter can take while the election is in the “Building” state:</p>
         <ul>
<li>Update all election settings</li>
<li>Manage the voters list</li>
<li>Manage the candidate</li>
         </ul> 
           <p><b>Voters</b></p>
           <p>Voters cannot access an election that is in the “Building” state</p>

           <p><b>2. Scheduled</b></p>
           <p>On completing the process of creating an election, an election will enter the “Scheduled” state. A
“Scheduled” election will automatically start (change to the “Running” state) on the start date defined in
the election settings. </p>

           <p><b>Scheduled Election Permissions</b></p>
           <p>The following summarizes the different actions an Election Administrator 
           and Voter can take while the election is in the “Scheduled” state:</p>
           <p><b>Election Administrators</b></p>
        <ul>
<li>Manage the voters list.</li>
<li> Manage and add candidates.</li>
<li> Update election settings. </li>
<li> Update the start and close date of the election.  </li>
        </ul>
           <p><b>Voters</b></p>
        <ul>
<li>Can access the created election’s page, register for it but will not be able vote in the election.</li>
<li>Ask candidates questions, view their profile and read their replies. </li>
        </ul>

            <p><b>3. Running</b></p>
            <p>Once an election enters the “Running” state, it has officially started. The election will automatically end
on the date set in the settings unless the election administrator chooses to close the election before that
date.</p>
             <p><b>Running Election Permissions</b></p>
             <p>The following summarizes the different actions an Election Administrator and 
             Voter can take while the election is in the “Running” state:</p>
             <p><b>Election Administrators</b></p>
          <ul>
<li>Can manage the voters list.</li> 
<li>View the candidates for the election.</li> 
<li>View the results of the election.</li> 
         </ul> 
             <p><b>Voters</b></p>
         <ul>
<li>Can now login to the election and cast their votes</li>
<li>Can write in a candidate.</li> 
<li>View progress and predictions. </li>
        </ul> 
             
             <p><b>4. Completed</b></p>
             <p>Elections enter the “Completed” state when the election administrator closes 
             the election or the election closes automatically on the close date.</p>
             <p><b>Completed Election Permissions</b></p>
             <p>The following summarizes the different actions an Election Administrator and 
             Voter can take while the election is in the “Completed” state:</P>
             <p><b>Election Administrators</b></p>
        <ul>
<li>View the results of the election (see: Election Results).</li>

       </ul>   
             <p><b>Voters</b></p>
       <ul>
<li>Can see the winner of an election.</li> 
<li>Can view election results.</li>
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
  name: 'electionHelp',
  props: {
    msg: String
  }
}
</script>