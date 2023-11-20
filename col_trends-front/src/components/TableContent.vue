<script setup lang="ts">
    import { useData } from '@/stores/data';
    import { computed } from 'vue';
    const dataStore = useData();
    const fields = computed(() => dataStore.data.schema?.fields || []);
    const data = computed(() => dataStore?.data?.rows || []);
</script>
<template>
    <child></child>
    <table>
        <thead>
            <tr>
                <th v-for="field in fields" :key="field.name">{{ field.name }}</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(row,key) in data" :key="key">
                <td v-for="field in row" :key="field.value">{{ field.value }}</td>
            </tr>
        </tbody>
    </table>
</template>

<style lang="css">
    table {
    border-collapse: collapse;
    width: 100%;
    }

    th, td {
    border: 1px solid black;
    padding: 5px;
    }

    th {
    background-color: #eee;
    }

    tbody tr:nth-child(odd) {
    background-color: #fff;
    }

    tbody tr:nth-child(even) {
    background-color: #f5f5f5;
}
</style>