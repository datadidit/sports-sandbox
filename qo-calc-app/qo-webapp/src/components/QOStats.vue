<template>
  <v-layout>
    <v-flex xs12 sm6 offset-sm3>
      <v-card>
        <!--
        <v-card-media src="/static/doc-images/cards/desert.jpg" height="200px">
        </v-card-media>
        -->
        <v-card-title primary-title>
          <div>
            <h3 class="headline mb-0">Qualifying Offer Summary Stats</h3>
            <div>
              <h4>Mean: {{ mean }}</h4>
            </div>
          </div>
        </v-card-title>
        <!--
        <v-card-actions>
          <v-btn flat color="orange">Share</v-btn>
          <v-btn flat color="orange">Explore</v-btn>
        </v-card-actions>
        -->
      </v-card>
    </v-flex>
  </v-layout>
</template>

<script>
export default{
  name: 'qostats',
  computed: {
    mean(){
      return this.$store.getters.mean
    }
  }
}
</script>
