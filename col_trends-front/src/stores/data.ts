import { defineStore } from 'pinia';
import { ref } from 'vue';

interface Field {
  name: string;
  type: {
    equivalent: string;
    constant: string;
  };
  mode: string;
}

interface Row {
  [key: string]: {
    attribute: string;
    value: string;
  };
}

interface Data {
  schema?: {
    fields: Field[];
  };
  totalRows?: number;
  rows?: Row[];
}

export const useData = defineStore("data",() => {
    const data = ref<Data>({rows:[]});
    const setData = (_data: Data) => {
        data.value = _data;
      }
      const setDataValue = (_data: Data) => {
        data.value = {...data.value ,..._data};
      }
      return {data, setData, setDataValue};
});