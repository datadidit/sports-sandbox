<template>
<v-flex xs12>
	<v-card>
          <v-toolbar card color="blue" prominent>
            <v-toolbar-title class="body-2 black--text">Qualifying Offer Input</v-toolbar-title>
          </v-toolbar>
          <v-divider></v-divider>
          <v-card-text>
			<v-text-field
				name="input-2"
				label="Top N Salaries"
				v-model="topNSalaries"
			></v-text-field>
		</v-card-text>
		<v-card-actions>
          <v-btn color="green" @click="generateReport">Generate Report</v-btn>
        </v-card-actions>
	</v-card>
</v-flex>	
</template>

<script>
export default {
	name: 'reportinput',
	computed: {
		topNSalaries:{
			get(){
				return this.$store.getters.topNSalaries
			},
			set(value){
				return this.$store.dispatch('setTopNSalaries', value)
			}
		}
	},
	methods: {
		generateReport(){
			this.$store.dispatch('calculateQOReport', this.topNSalaries)
		}
	}
}
</script>