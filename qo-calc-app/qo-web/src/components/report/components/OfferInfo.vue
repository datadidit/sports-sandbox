<template>
<v-flex>	
	<v-card>
          <v-toolbar card color="blue" prominent>
            <v-toolbar-title class="body-2 black--text">Qualifying Offer</v-toolbar-title>
          </v-toolbar>
          <v-divider></v-divider>
         <v-card-text>
         	<v-container>
         		<h4><b>Qualifying Offer:</b> {{ report.mean.formattedValue }}</h4>
         	</v-container>
        	<v-subheader>Additional Statistics</v-subheader>
        	<v-container>
                    <p><b>Minimum Salary:</b> {{ report.minimum.formattedValue }}</p>
         			<p><b>Maximum Salary:</b> {{ report.maximum.formattedValue }}</p>
         			<p><b>Standard Deviation:</b> {{ report.standardDeviation.formattedValue }}</p>
         		</ul>
         	</v-container>
		</v-card-text>
	</v-card>
</v-flex>
</template>

<script>
export default {
	name: 'offerinfo',
    props: ['report']
}
</script>