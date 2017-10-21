<template>
	<v-flex xs12>
		<v-card>
			<v-toolbar card color="blue" prominent>
				<v-toolbar-title class="body-2 black--text">Team Impact</v-toolbar-title>
			</v-toolbar>
			<v-divider></v-divider>
			<v-card-text>
				<v-layout row>
					<v-flex xs6>
						<div>
							<h4>Offers Made:</h4>
						<h1>{{ offers }}</h1>							
						</div>
						<div>
						<h4>Offers Percentage of Payroll</h4>
						<h1>{{ percentage }}</h1>
						</div>
					</v-flex>
					<v-flex xs6>
						<teampie 
							:chart-data="chartdata"
							:payroll="payroll"
							:offers="offers"
						/>
					</v-flex>          	
				</v-layout>
			</v-card-text>
		</v-card>
	</v-flex>
</template>

<script>
	import TeamPie from './TeamPie.vue'

	export default {
		name: 'teamimpact',
		computed: {
			offers(){
				return this.$store.getters.offers
			},
			chartdata(){
				return this.$store.getters.chartdata
			},
			percentage(){
				return this.$store.getters.percentage
			}
		},
		components: {
			'teampie' : TeamPie
		},
		methods: {
			generateChart(){
				this.$store.dispatch('generateChart')
			}
		}
	}
</script>