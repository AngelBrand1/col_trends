<!-- <script setup lang="ts">
import { useData } from '@/stores/data';
import { onMounted, ref, watch } from 'vue';
import * as d3 from 'd3';

  const dataStore = useData();
  const fields = ref(dataStore.data.schema?.fields || []);
  const xField = ref('');
  const yField = ref('');
  const sizeField = ref('');
  const colorField = ref('');
  const options = {
      width: 600,
      height: 400,
      margin: { top: 10, right: 10, bottom: 10, left: 10 },
      color: d3.scaleOrdinal(d3.schemeCategory10),
      tooltip: true,
    };

    const drawChart = () => {
      const data = dataStore.data.rows || [];

      const svg = d3
        .select('#chart')
        .append('svg')
        .attr('width', options.width)
        .attr('height', options.height);

      const xScale = d3
        .scaleLinear()
        .domain(d3.extent(data, (d) => +d[xField.value]))
        .range([options.margin.left, options.width - options.margin.right]);

      const yScale = d3
        .scaleLinear()
        .domain(d3.extent(data, (d) => +d[yField.value]))
        .range([options.height - options.margin.bottom, options.margin.top]);

      const sizeScale = d3
        .scaleLinear()
        .domain(d3.extent(data, (d) => +d[sizeField.value]))
        .range([5, 20]);

      const colorScale = d3
        .scaleOrdinal()
        .domain(data.map((d) => d[colorField.value]))
        .range(d3.schemeCategory10);

      const node = svg
        .selectAll('.node')
        .data(data)
        .enter()
        .append('g')
        .attr('class', 'node')
        .attr('transform', (d) => `translate(${xScale(+d[xField.value])},${yScale(+d[yField.value])})`);

      node
        .append('circle')
        .attr('r', (d) => sizeScale(+d[sizeField.value]))
        .style('fill', (d) => colorScale(d[colorField.value]));

      if (options.tooltip) {
        node
          .append('title')
          .text((d) => `${d.term}: ${d.percent_gain}%`);
      }
    };

    onMounted(() => {
      drawChart();
    });

    watch(
      () => dataStore.data,
      () => {
        fields.value = dataStore.data.schema?.fields || [];
        d3.select('#chart svg').remove();
        drawChart();
      }
    );

    watch([xField, yField, sizeField, colorField], () => {
      d3.select('#chart svg').remove();
      drawChart();
    });
    
</script>

<template>
  <div>
    <div>
      <label for="x-field">X Field:</label>
      <select id="x-field" v-model="xField">
        <option v-for="(field, index) in fields" :value="field.name" :key="index">{{ field.name }}</option>
      </select>
    </div>
    <div>
      <label for="y-field">Y Field:</label>
      <select id="y-field" v-model="yField">
        <option v-for="(field, index) in fields" :value="field.name" :key="index">{{ field.name }}</option>
      </select>
    </div>
    <div>
      <label for="size-field">Size Field:</label>
      <select id="size-field" v-model="sizeField">
        <option v-for="(field, index) in fields" :value="field.name" :key="index">{{ field.name }}</option>
      </select>
    </div>
    <div>
      <label for="color-field">Color Field:</label>
      <select id="color-field" v-model="colorField">
        <option v-for="(field, index) in fields" :value="field.name" :key="index">{{ field.name }}</option>
      </select>
    </div>
    <div ref="chart"></div>
  </div>
</template>
 -->
