import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useDataQueryStore = defineStore('dataQuery', () => {
  const data = ref<any>({});


  return { data}
})
