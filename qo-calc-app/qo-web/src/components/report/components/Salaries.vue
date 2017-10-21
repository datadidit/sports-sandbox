<template>
	<v-flex xs12>
		<v-card>
			<v-toolbar card color="blue" prominent>
				<v-toolbar-title class="body-2 black--text">Salaries</v-toolbar-title>
			</v-toolbar>
			<v-divider></v-divider>
			<v-card-title>
				<v-spacer></v-spacer>
				<v-text-field
				append-icon="search"
				label="Search"
				single-line
				hide-details
				v-model="search"
				></v-text-field>
			</v-card-title>
			<v-data-table
			v-bind:headers="headers"
			v-bind:items="salaries"
			v-bind:search="search"
			v-bind:pagination.sync="pagination"
			>
			<template slot="items" scope="props">
				<td>
					{{props.item.name}}
				</td>
				<td class="text-xs-right">{{ props.item.salary }}</td>
			</template>
			<template slot="pageText" scope="{ pageStart, pageStop }">
				From {{ pageStart }} to {{ pageStop }}
			</template>
		</v-data-table>
	</v-card>
</v-flex>
</template>

<script>
	export default {
		name: 'salaries',
		props: ['salaries'],
		data(){
			return {
				max25chars: (v) => v.length <= 25 || 'Input too long!',
				tmp: '',
				search: '',
				pagination: {},			
				headers: [
				{
					text: 'Player Name',
					align: 'left',
					sortable: true,
					value: 'name'
				},
				{
					text: 'Salary',
					align: 'left',
					sortable: true,
					value: 'longSalary'
				}
				],
				/*players: [
				{
					name: 'Bryce Harper',
					salary: '$2,500,000',
					longSalary: 2500000
				},
				{
					name: 'Max Scherzer',
					salary: '$5,000,000',
					longSalary: 5000000
				}
				]*/
			}
		}	
	}
</script>