INSERT INTO cities (slug, name_en, name_hi) VALUES
  ('delhi','Delhi','दिल्ली'),
  ('mumbai','Mumbai','मुंबई'),
  ('pune','Pune','पुणे'),
  ('bangalore','Bangalore','बेंगलुरु'),
  ('kolkata','Kolkata','कोलकाता'),
  ('hyderabad','Hyderabad','हैदराबाद')
ON CONFLICT (slug) DO NOTHING;

INSERT INTO categories (slug, name_en, name_hi) VALUES
  ('electrician','Electrician','इलेक्ट्रीशियन'),
  ('plumber','Plumber','प्लंबर'),
  ('carpenter','Carpenter','बढ़ई'),
  ('painter','Painter','पेंटर'),
  ('ac-technician','AC Technician','एसी टेक्नीशियन'),
  ('construction-worker','Construction Worker','निर्माण श्रमिक'),
  ('civil-engineer','Civil Engineer','सिविल इंजीनियर'),
  ('interior-designer','Interior Designer','इंटीरियर डिज़ाइनर'),
  ('cleaner','Cleaner','क्लीनर'),
  ('sweeper','Sweeper','सफाई कर्मचारी')
ON CONFLICT (slug) DO NOTHING;
