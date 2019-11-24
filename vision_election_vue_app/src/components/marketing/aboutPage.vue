<template>
    <div>
      <b-container>
        <b-carousel
          id="carousel-1"
          v-model="slide"
          :interval="4000"
          controls
          indicators
          background="#ababab"
          img-width="1024"
          img-height="480"
          style="text-shadow: 1px 1px 2px #333;"
          @sliding-start="onSlideStart"
          @sliding-end="onSlideEnd"
        >
          <b-carousel-slide caption="Lawrence Mielke" img-src="https://cdn.pixabay.com/photo/2017/08/04/06/50/san-diego-2579194_960_720.jpg">
            <p>
    Lawrence is a Graduate Software Engineering student at Penn State University and currently lives in San Diego California.  Lawrence got his Bachelor of Science degree in Game Art & Design at the Art Institute of California – Orange County.  He is currently working as a Senior Business Applications Developer at D&K Engineering.  Lawrence has also been a Software Development Analyst for Northrop Grumman supporting enterprise integration. 
            </p>
          </b-carousel-slide>
          <b-carousel-slide caption="Brent Robbins" img-src="https://cdn.pixabay.com/photo/2017/08/12/06/22/delaware-water-gap-2633627_960_720.jpg">
            <p>
    Brent is a Graduate Software Engineering student and Penn State University and lives in West Wyoming Pennsylvania. He obtained his Bachelor of Science degree at Penn State’s Wilkes-Barre campus in the Fall of 2011. Brent is currently employed as an Account Development Programmer at Map Communications Inc. 
            </p>
          </b-carousel-slide>
          <b-carousel-slide caption="Kylie Gorman" img-src="https://cdn.pixabay.com/photo/2013/12/07/05/05/ocean-city-224436_960_720.jpg">
            <p>
    Kylie is a Graduate Software Engineering student and Penn State University and lives right by the beach in Manahawkin, New Jersey. She received her Bachelor of Science degree in Computer Science at the College of New Jersey and minored in Interactive Multimedia. Kylie is currently working at as a Software Engineer for Leidos in the William J. Hughes Technical Center as a contractor to the FAA to update and maintain air traffic control systems.  
            </p>
          </b-carousel-slide>
          <b-carousel-slide caption="Ifeoma Duruike" img-src="https://cdn.pixabay.com/photo/2015/09/26/16/00/independence-day-959257_960_720.jpg">
          <p>
            Ifeoma is a Graduate Software Engineering student at Penn State University and lives in Katy, Texas. She obtained her Bachelor of Science degree in Computer Science at the University of Ilorin in 2007. Ifeoma is currently employed at Chi St. Lukes Hospital. 
          </p>
          </b-carousel-slide>
        </b-carousel>
      </b-container>
    </div>
</template>


<script>
export default {
  name: 'aboutPage',
  props: {
    msg: String
  },
  data() {
      return {
        slide: 0,
        sliding: null
      }
    },
    methods: {
      onSlideStart() {
        this.sliding = true
      },
      onSlideEnd() {
        this.sliding = false
      }
    }
  
}
</script>