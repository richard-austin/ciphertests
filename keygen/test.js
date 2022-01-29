const serial = require("generate-serial-key")

console.log(serial.generate()); // Outputs 'AG8D-ZGYG-A8YV-PVMK'
console.log(serial.generate(20, "_", 5)); // Outputs 'UL3MV_BTPXB_MBEU9_QK3MC'
