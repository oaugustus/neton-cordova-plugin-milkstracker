
var exec = require('cordova/exec');

var PLUGIN_NAME = 'NetonCordovaPluginMilksTracker';

var MilksTrackerPlugin = {
  start: function(phrase, cb) {
    exec(cb, null, PLUGIN_NAME, 'start', []);
  },
  stop: function(cb) {
    exec(cb, null, PLUGIN_NAME, 'stop', []);
  }
};

module.exports = MilksTrackerPlugin;
