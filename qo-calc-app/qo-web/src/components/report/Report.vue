<template>
<v-container grid-list-md text-xs-center>
 <v-layout row wrap>
 	<reportinput />
 	<offer :report="report"/>
 	<salaries :salaries="report.salaries" />
 </v-layout>
</v-container>
</template>

<script>
	import ReportInput from './components/ReportInput'
	import OfferInfo from './components/OfferInfo'
	import Salaries from './components/Salaries'

	export default {
		name: 'report',
		components: {
			'reportinput' : ReportInput,
			'offer' : OfferInfo,
			'salaries' : Salaries
		},
		computed: {
			settings(){
				return this.$store.getters.settings
			},
			report(){
				return this.$store.getters.report
			}
		}
	}
</script>