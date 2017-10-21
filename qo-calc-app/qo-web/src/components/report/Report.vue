<template>
	<v-container grid-list-md text-xs-center>
		<v-layout row wrap>
			<reportinput />
			<offer :report="report"/>
			<salaries :salaries="report.salaries" />
			<div v-if="loading" class="modal-mask">
				<div class="modal-wrapper">
					<div class="spinner-container">
						<v-progress-circular indeterminate v-bind:size="150" v-bind:width="7" color="green"></v-progress-circular>
					</div>
				</div>
			</div> 	
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
			},
			loading(){
				return this.$store.getters.loading
			}
		}
	}
</script>

<style>
	.modal-mask {
		position: fixed;
		z-index: 9998;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		background-color: rgba(0, 0, 0, .5);
		display: table;
		transition: opacity .3s ease;
	}

	.modal-wrapper {
		display: table-cell;
		vertical-align: middle;
	}

	.spinner-container {
		width: 300px;
		margin: 0px auto;
		transition: all .3s ease;
	}
</style>