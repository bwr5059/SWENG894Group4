<template>
<b-container>
<b-row>
<div class="jumbotron">
  <h1 class="display-4">Vision Election</h1>
    <p class="lead">Will provide a valuable and effective election software to manage free and fair elections of the different student electoral bodies in universities through the participation of students and staff in deepening electoral democracy. This electronic voting system will enable any eligible voter to vote using any mobile or desktop device with internet services during an election period. {Vision Election System} will promote democracy in the schools it is used by delivering the highest standards of accuracy, privacy, security, validation, and reliability.</p>

    <p>Find out if Vision Election is the right tool for you!</p>
    <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
</div>
</b-row>
<b-row>
  <b-col>
  <b-card
    title="Customize Elections"
    img-src="https://images.unsplash.com/photo-1494172961521-33799ddd43a5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1351&q=80"
    img-alt="Image"
    img-top
    tag="article"
    style="max-width: 20rem;"
    class="mb-2"
  >
    <b-card-text>
      Fast and easy creation of elections without the hassle. Vision Election System offers many policy customization options to control the voting process.
      <br>
      <br>
    </b-card-text>
  </b-card>
  </b-col>
  <b-col>
    <b-card
    title="Manage Elections"
    img-src="https://images.unsplash.com/photo-1540908390241-82158ab62887?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80"
    img-alt="Image"
    img-top
    tag="article"
    style="max-width: 20rem;"
    class="mb-2"
  >
    <b-card-text>
   Worry free management of your elections. Control who can vote in elections by issuing a generated key and remove voters who can no longer vote. Add and remove candidates before the start of an election.   
    </b-card-text>
  </b-card>
  </b-col>
  <b-col>
    <b-card
    title="Participate"
    img-src="https://cdn.pixabay.com/photo/2016/11/07/00/49/vote-1804596_960_720.jpg"
    img-alt="Image"
    img-top
    tag="article"
    style="max-width: 20rem;"
    class="mb-2"
  >
    <b-card-text>
      Participate as a voter in an election with a few simple clicks. Our easy to use interface makes your online voting experience worry free.  
      <br>
      <br>
      <br>
    </b-card-text>
  </b-card>
  </b-col>
</b-row>
</b-container>
</template>

<script>
export default {
  name: 'landing',
  props: {
    msg: String
  }
}
</script>
