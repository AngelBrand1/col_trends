<script setup lang="ts">
    import { useDataQueryStore } from '@/stores/data_query';

    const dataQuery = useDataQueryStore();

</script>
<template>
    <div>
        <table>
            <thead>
                <tr>
                    <th>abbreviation</th>
                    <th>name</th>
                </tr>
            </thead>
            <tbody>

                <tr v-for="item in dataQuery.data ?? []" :key="item.name">
                    <td>{{ item.abbreviation }}</td>
                    <td>{{ item.name }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>


<style lang="scss" scoped>
</style>