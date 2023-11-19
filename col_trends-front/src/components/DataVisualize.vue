<script setup lang="ts">
import { useDataQueryStore } from '@/stores/data_query';

const dataQuery = useDataQueryStore();
async function  handleClick() {
    let res:any = await fetch('http://localhost:8080/api/data');
    res = await res.json();
    console.log(res);
    let data:any = res;
    dataQuery.$patch({data});
}
</script>
<template>
    <div>
        <h1>Data Visualize</h1>
        <button @click="handleClick" type="button">execute</button>
    </div>
</template>


<style lang="scss" scoped></style>