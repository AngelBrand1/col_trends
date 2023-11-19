<template>
  <div>
    <h2>Fields:</h2>
    <div v-for="(field, index) in fields" :key="field"> 
      <input type="checkbox" :id="'field-' + index" :value="field" v-model="query.fields">
      <label :for="'field-' + index">{{ field }}</label>
    </div>
    <h2>Order by:</h2>
    <div class="radio-select">
      <div style="height: 100px;">

        <div v-for="field in selectedFields" :key="field">
          <input type="radio" :id="field" :value="field" v-model="query.order">
          <label :for="field">{{ field }}</label>
        </div>
      </div>
      <h3>Order type:</h3>
      <div>
        <input type="checkbox" id="desc" :value="true" v-model="query.desc">
        <label for="desc">Desc</label>
      </div>
    </div>
    <h2>After date</h2>
    <input type="date" v-model="query.filter">
  </div>
</template>

<script setup lang="ts">
import { useQueryStore } from '@/stores/queryParameters';
import { URL_BACK } from '@/env';
import { computed, onBeforeMount, ref } from 'vue';
const fields = ref();
const { query } = useQueryStore();
const getFields = async () => {
  let res: any = await fetch(`${URL_BACK}/fields`)
    .catch(() => null);
  res = await res?.json();
  fields.value = res;
}
onBeforeMount(() => {
  getFields()
});
const selectedFields = computed(() => {
  return fields?.value?.filter((field: string )=> query?.fields?.includes(field));
});
</script>


<style>
  .radio-select{
    height: 170px;
  }
  h2{
    margin-block-start: 0.2em;
    margin-block-end: 0.2em;
  }
  h3{
    margin-block-start: 0.1em;
    margin-block-end: 0.1em;
  }
</style>