<script setup lang="ts">
import { useDataQueryStore } from '@/stores/data_query';

const dataQuery = useDataQueryStore();
async function  handleClick() {
    let res:any = await fetch('https://gist.githubusercontent.com/enriqueornelasjr/57cc380aa96a3e041e4886202c30e40c/raw/bccfbee870c0bff1ba04b35eb84f515923b8236b/Months.json');
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