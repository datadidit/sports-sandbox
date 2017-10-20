<template>
  <v-layout>
    <v-flex xs12 sm6 offset-sm3>
      <v-card>
        <!--
        <v-card-media src="/static/doc-images/cards/desert.jpg" height="200px">
        </v-card-media>
        -->
        <v-card-title primary-title>
            <h3 class="headline mb-0">Qualifying Offer Summary Stats</h3>
        </v-card-title>
        <v-card-text>
            <div>
              <h6>Qualifying Offer: {{ mean.formatedValue }}</h6>
            </div>
            <div>
              <h6>Maximum: {{ maximum.formatedValue }}</h6>
            </div>
            <div>
              <h6>Minimum: {{ minimum.formatedValue }}</h6>
            </div>                      
        </v-card-text>
      </v-card>
    </v-flex>
  </v-layout>
</template>

<script>
export default{
  name: 'qostats',
  props: ['mean', 'minimum', 'maximum', 'standardDeviation']
}
</script>
