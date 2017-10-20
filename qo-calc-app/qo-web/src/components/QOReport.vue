<template>
<div>
	<qostats 
		:mean="mean" 
		:minimum="minimum"
		:maximum="maximum"
		:standardDeviation="standardDeviation"></qostats>
	<qotable :salaries="salaries"></qotable>
</div>
</template>

<script>
import QOTable from './QOTable.vue'
import QOStats from './QOStats.vue'

export default {
	name: 'qoreport',
	components: {
		'qotable' : QOTable,
		'qostats' : QOStats
	},
	computed: {
		salaries(){
			return this.$store.getters.salaries
		},
		mean(){
			return this.$store.getters.mean
		},
		minimum(){
			return this.$store.getters.minimum
		},
		standardDeviation(){
			return this.$store.getters.standardDeviation
		},
		maximum(){
			return this.$store.getters.maximum
		}
	},
	mounted(){
		this.$store.dispatch('calculateQOReport', 125)
	}
}
</script>