// const { chromium, devices } = require('playwright');
//
// (async () => {
//     const browser = await chromium.launch({ headless: false });
//     const page = await browser.newPage();
//
//     await page.goto('https://practice.cydeo.com/dropdown');
//
//     const expectedYear = '1988';
//     const expectedMonth = 'January';
//     const expectedDay = 12;
//
//     await page.waitForTimeout(1000);
//
//     const yearDropdown = await page.$('#year');
//     const monthDropdown = await page.$('#month');
//     const dayDropdown = await page.$('#day');
//
//     // Select with value
//     await yearDropdown.selectOption({ value: expectedYear });
//     await page.waitForTimeout(1000);
//
//     // Select with text (label)
//     await monthDropdown.selectOption({ label: expectedMonth });
//     await page.waitForTimeout(1000);
//
//     // Select with index
//     await dayDropdown.selectOption({ index: expectedDay - 1 });
//
//     await page.waitForTimeout(3000);
//
//     const actualYear = await page.evaluate(el => el.selectedOptions[0].text, yearDropdown);
//     const actualMonth = await page.evaluate(el => el.selectedOptions[0].text, monthDropdown);
//     const actualDay = await page.evaluate(el => el.selectedOptions[0].text, dayDropdown);
//
//     console.log('actualYear =', actualYear);
//     console.log('actualMonth =', actualMonth);
//     console.log('actualDay =', actualDay);
//
//     console.log('with DOM knowledge', await page.evaluate(() => document.querySelector('#year').value));
//
    await browser.close();